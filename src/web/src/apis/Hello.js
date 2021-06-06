import request from '../utils/request'

export function hello (name) {
  return request(`/apis/reap-demo/hello/${name}`, { method: 'GET' })
}
