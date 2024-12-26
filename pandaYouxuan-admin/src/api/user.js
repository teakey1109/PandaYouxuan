import request from '@/utils/request';

export function login(data) {
  console.log('Sending login data:', data); // 调试信息
  return request({
    url: '/admin/system/index/login',
    method: 'post',
    data
  });
}

export function getInfo(token) {
  return request({
    // url: '/vue-element-admin/user/info',
    url: '/admin/system/index/info', // 本地登录接口API路径
    method: 'get',
    params: { token }
  });
}

export function logout(token) {
  return request({
    url: '/vue-element-admin/user/logout',
    method: 'post',
    params: { token }
  });
}
