// 本文件用于应用程序全局枚举量注册(不可更改)
const GroupEnum = {
  // 日志类型
  LogType : {
    // 完成
    SUCCESS : 0,
    // 异常
    EXCEPTION : 1,
    // 警告
    WARRING : 2
  },
  // 日志级别
  LevelType : {
    // 系统级别
    SYSTEM : 0,
    // 模块级别
    MODEL : 1,
    // 函数级别
    FUNCTION : 2
  },
  // 最小模块加载量
  ModuleLoad : {
    // 基础零时间
    ZEROLOAD : 0,
    // 最小加载时间
    SLOWLOAD : 2500,
    // 最大加载时间
    FASTLOAD : 3000
  },
  // 屏幕朝向
  SrceenOrientation : {
    // 横屏
    TRANSVERSE : 0,
    // 竖屏
    VERTICAL : 1
  },
  // 待办...
};
// 一定要封存对象
Object.freeze(GroupEnum);