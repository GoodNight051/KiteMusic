// 本文件存放各种全局通用函数或者方法
// 只有具有极高抽象性的才可以存放在此
// 个别与页面紧密相连的方法函数
// 可以存放在view.js中(这个文件用于分类管理页面通用函数)
const AppUtil = {};
// 对随机数的扩展
AppUtil.Random = {
  // 该方法返回一个[min,max]内的随机整数
  getNumber : function(min,max){
    return Math.floor(Math.random() * (max - min + 1)) + min;
  },
  // 该方法返回一个随机布尔值
  getBool : function(){
    let val = this.getNumber(0,1);
    if(val == 0) return false;
    return true;
  }
};