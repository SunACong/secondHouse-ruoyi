import request from '@/utils/request'

// 查询小区列表
export function listHousing(query) {
  return request({
    url: '/houseservice/housing/list',
    method: 'get',
    params: query
  })
}

// 查询商圈列表
export function listDistric(query) {
  return request({
    url: '/houseservice/housing/selectDistricList',
    method: 'get',
    params: query
  })
}

// 查询小区列表
export function listHome(query) {
  return request({
    url: '/houseservice/housing/selectHomeList',
    method: 'get',
    params: query
  })
}

// 查询小区详细
export function getHousing(id) {
  return request({
    url: '/houseservice/housing/' + id,
    method: 'get'
  })
}

// 新增小区
export function addHousing(data) {
  return request({
    url: '/houseservice/housing',
    method: 'post',
    data: data
  })
}

// 修改小区
export function updateHousing(data) {
  return request({
    url: '/houseservice/housing',
    method: 'put',
    data: data
  })
}

// 删除小区
export function delHousing(id) {
  return request({
    url: '/houseservice/housing/' + id,
    method: 'delete'
  })
}

// 导出小区
export function exportHousing(query) {
  return request({
    url: '/houseservice/housing/export',
    method: 'get',
    params: query
  })
}
