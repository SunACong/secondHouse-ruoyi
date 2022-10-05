import request from '@/utils/request'

// 查询房源上传列表
export function listUpload(query) {
  return request({
    url: '/houseservice/upload/listInfo',
    method: 'get',
    params: query
  })
}

// 查询房源上传详细
export function getUpload(id) {
  return request({
    url: '/houseservice/upload/' + id,
    method: 'get'
  })
}

// 新增房源上传
export function addUpload(data) {
  return request({
    url: '/houseservice/upload',
    method: 'post',
    data: data
  })
}

// 修改房源上传
export function updateUpload(data) {
  return request({
    url: '/houseservice/upload',
    method: 'put',
    data: data
  })
}

// 删除房源上传
export function delUpload(id) {
  return request({
    url: '/houseservice/upload/' + id,
    method: 'delete'
  })
}

// 导出房源上传
export function exportUpload(query) {
  return request({
    url: '/houseservice/upload/export',
    method: 'get',
    params: query
  })
}
