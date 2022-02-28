# AndroidP-Launcher3魔改初体验

**结合Android P（9.0.0_r61） Launcher3源码，魔改一个具有个人特色的Launcher，真正的拥有一个属于自己的桌面系统。**

## 配置环境：

* Android Studio版本：3.6.3（高版本也行，可能会出现兼容性错误）
* Gradle版本：5.6.4-all（高版本也行，可能会出现兼容性错误）
* 测试Android版本：建议选择 API 28（Android 9.0）及以上
* 测试机器：支持Android9(及以上)版本的安卓模拟器或真机（切勿使用云测试平台调试）
* 其他配置待补充...

----

> 【备注】：为了防止导入报错，这里把本应该忽略的配置文件（`/gradle/`，`/build/`，`gradle.properties`，`local.prpperties`）都上传上来了，如有需要可以替换成你自己的。

----------

## 更新记录：

* 1.基本环境配置

* 2.禁止滑动指示器自动隐藏，自定义滑动指示器颜色。

----

## 关键类介绍：

* Launcer：显示Launcher的主Activity。我们看到的桌面就是它，是最核心且唯一的Activity。
* LauncherAppState：单例对象，构造方法中初始化对象、注册应用安装、卸载、更新，配置变化等广播。这些广播用来实时更新桌面图标等，其receiver的实现在LauncherModel类中，LauncherModel也在这里初始化。
* LauncherModel：数据处理类，保存桌面状态，提供读写数据库的API，内部类LoaderTask用来初始化桌面。
* InvariantDeviceProfile：一些不变的设备相关参数管理类，其内部包涵了横竖屏模式的DeviceProfile。
* IconCache：图标缓存类，应用程序icon和title的缓存，内部类创建了数据库app_icons.db。
* LauncherProvider：核心数据库类，负责launcher.db的创建与维护。
* DragLayer：一个用来负责分发事件的ViewGroup。
* DragController：DragLayer只是一个ViewGroup，具体的拖拽的处理都放到了DragController中。
* BubblTextView：图标都基于他，继承自TextView。
* Folder：打开文件夹展示的View。
* FolderIcon：文件夹图标。
* ItemInfo：桌面上每个Item的信息数据结构，包括在第几屏、第几行、第几列、宽高等信息；该对象与数据库中记录一一对应；该类有多个子类，譬如FolderIcon的FolderInfo、BubbleTextView的ShortcutInfo等。
* Workspace：显示Launcher界面的视图。
* CellLayout：Workspace中显示多页，每一页就是一个CellLayout。
* ShortcutAndWidgetContainer：CellLayout中存放子View（即应用图标或小控件）的ViewGroup，即真正包含子View的容器。
* Hotseat：Workspace下的快捷栏。
