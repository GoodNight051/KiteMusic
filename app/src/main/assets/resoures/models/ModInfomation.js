// 本模块标明了需要载入的所有模块信息
const ModInfomation = {
  animate : {
    version : '2.1',
    modInfo : 'plugins/animate/LICENSE.md',
    script  : [null],
    style   : [
      'plugins/animate/animate.css'
    ]
  },
  anime : {
    version : '2.0.0',
    modInfo : 'plugins/anime/LICENSE.md',
    script  : [
      'plugins/anime/anime.min.js'
    ],
    style   : [null]
  },
  daisyui : {
    version : '5.0',
    modInfo : 'plugins/daisyui/LICENSE.md',
    script  : [
      'plugins/daisyui/browser@4.js'
    ],
    style   : [
      'plugins/daisyui/daisyui@5.css'
    ]
  },
  layui : {
    version : '2.8.3',
    modInfo : 'plugins/layui/LICENSE.md',
    script  : [null],  // 已经手动加载
    style   : [
      'plugins/layui/css/layui.css',
    ]
  },
  mui : {
    version : '3.7.2',
    modInfo : 'plugins/mui/LICENSE.md',
    script  : [
      'plugins/mui/dist/js/mui.js'
    ],
    style   : [
      'plugins/mui/dist/css/mui.css'
    ]
  },
  swiper : {
    version : '11.0.0',
    modInfo : 'plugins/swiper/LICENSE.md',
    script  : [
      'plugins/swiper/swiper-bundle.js'
    ],
    style   : [
      'plugins/swiper/swiper-bundle.css'
    ]
  },
};
// 一定要封存对象
Object.freeze(ModInfomation);