import request from '@/utils/request'

// 查询客源管理列表
export function listCustomerManagement(query) {
  return request({
    url: '/houseservice/customerManagement/listInfo',
    method: 'get',
    params: query
  })
}

// 查询客源管理详细
export function getCustomerManagement(id) {
  return request({
    url: '/houseservice/customerManagement/' + id,
    method: 'get'
  })
}

// 新增客源管理
export function addCustomerManagement(data) {
  return request({
    url: '/houseservice/customerManagement',
    method: 'post',
    data: data
  })
}

// 修改客源管理
export function updateCustomerManagement(data) {
  return request({
    url: '/houseservice/customerManagement',
    method: 'put',
    data: data
  })
}

// 删除客源管理
export function delCustomerManagement(id) {
  return request({
    url: '/houseservice/customerManagement/' + id,
    method: 'delete'
  })
}

// 导出客源管理
export function exportCustomerManagement(query) {
  return request({
    url: '/houseservice/customerManagement/export',
    method: 'get',
    params: query
  })
}
