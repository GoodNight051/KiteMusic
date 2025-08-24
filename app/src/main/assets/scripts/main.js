function main() {
  // 对模块加载完成进行监听
  document.body.addEventListener('moduleInited',(event) => {
    event.stopPropagation();
    event.preventDefault();
    // 待办...
  });
  // 对屏幕旋转进行监听
  window.addEventListener('orientationchange',(event) => {
    event.stopPropagation();
    event.preventDefault();
    
    // 待办...
  });
}
// 这里对返回键进行监听
function onBackPressed() {
  // 等待资源初始化成功
  if(GroupStatic.coreInited){
    // 待办...
  }
}
$(main);