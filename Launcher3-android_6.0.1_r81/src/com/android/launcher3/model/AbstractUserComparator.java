/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.launcher3.model;

import android.content.Context;

import com.android.launcher3.ItemInfo;
import com.android.launcher3.compat.UserHandleCompat;
import com.android.launcher3.compat.UserManagerCompat;

import java.util.Comparator;

/**
 * A comparator to arrange items based on user profiles.
 */
public abstract class AbstractUserComparator<T extends ItemInfo> implements Comparator<T> {

    private final UserManagerCompat mUserManager;
    private final UserHandleCompat mMyUser;

    public AbstractUserComparator(Context context) {
        mUserManager = UserManagerCompat.getInstance(context);
        mMyUser = UserHandleCompat.myUserHandle();
    }

    @Override
    public int compare(T lhs, T rhs) {
        if (mMyUser.equals(lhs.user)) {
            return -1;
        } else {
            Long aUserSerial = mUserManager.getSerialNumberForUser(lhs.user);
            Long bUserSerial = mUserManager.getSerialNumberForUser(rhs.user);
            return aUserSerial.compareTo(bUserSerial);
        }
    }
}
