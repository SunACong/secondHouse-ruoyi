import request from '@/utils/request'

// 查询操作日志列表
export function listLog(query) {
  return request({
    url: '/houseservice/log/list',
    method: 'get',
    params: query
  })
}


// 删除操作日志
export function delLog(id) {
  return request({
    url: '/houseservice/log/' + id,
    method: 'delete'
  })
}

// 导出操作日志
export function exportLog(query) {
  return request({
    url: '/houseservice/log/export',
    method: 'get',
    params: query
  })
}
// 清空操作日志
export function cleanClog() {
  return request({
    url: '/houseservice/log/clean',
    method: 'delete'
  })
}
