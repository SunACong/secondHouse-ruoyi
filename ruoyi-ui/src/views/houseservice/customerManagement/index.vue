<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
<!--      <el-form-item label="公司id" prop="firmId">-->
<!--        <el-input-->
<!--          v-model="queryParams.firmId"-->
<!--          placeholder="请输入公司id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="部门id" prop="deptId">-->
<!--        <el-input-->
<!--          v-model="queryParams.deptId"-->
<!--          placeholder="请输入部门id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="用户id" prop="userId">-->
<!--        <el-input-->
<!--          v-model="queryParams.userId"-->
<!--          placeholder="请输入用户id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="角色id" prop="roleId">-->
<!--        <el-input-->
<!--          v-model="queryParams.roleId"-->
<!--          placeholder="请输入角色id"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="客源编号" prop="customId">-->
<!--        <el-input-->
<!--          v-model="queryParams.customId"-->
<!--          placeholder="请输入客源编号"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="上传者" prop="uploader">-->
<!--        <el-input-->
<!--          v-model="queryParams.uploader"-->
<!--          placeholder="请输入上传者"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="上传者电话" prop="uploaderPhone">-->
<!--        <el-input-->
<!--          v-model="queryParams.uploaderPhone"-->
<!--          placeholder="请输入上传者电话"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="公私盘" prop="gongSiPan">
        <el-select v-model="queryParams.gongSiPan" placeholder="请选择公私盘" clearable size="small">
          <el-option
            v-for="dict in gongSiPanOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="客户等级" prop="customerLever">
        <el-select v-model="queryParams.customerLever" placeholder="请选择客户等级" clearable size="small">
          <el-option
            v-for="dict in customerLeverOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="购房目的" prop="purpose">
        <el-select v-model="queryParams.purpose" placeholder="请选择购房目的" clearable size="small">
          <el-option
            v-for="dict in purposeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="客户姓名1" prop="name "  label-width="60">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入客户姓名1"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系方式1" prop="phoneNum" label-width="100">
        <el-input
          v-model="queryParams.phoneNum"
          placeholder="请输入联系方式1"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户姓名2" prop="nameOne" label-width="100">
        <el-input
          v-model="queryParams.nameOne"
          placeholder="请输入客户姓名2"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系方式2" prop="phoneNumber" label-width="100">
        <el-input
          v-model="queryParams.phoneNumber"
          placeholder="请输入联系方式2"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择客户性别" clearable size="small">
          <el-option
            v-for="dict in sexOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="区域" prop="region">
        <el-select v-model="queryParams.region" placeholder="请选择区域">
          <el-option
            v-for="dict in housingList"
            :key="dict"
            :label="dict"
            :value="dict"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="小区" prop="homeName">
        <el-select v-model="queryParams.homeName" placeholder="请选择小区">
          <el-option
            v-for="dict in homeList"
            :key="dict"
            :label="dict"
            :value="dict"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="总价" prop="allPrice">
        <el-select v-model="queryParams.allPrice" placeholder="请选择总价" clearable size="small">
          <el-option
            v-for="dict in allPriceOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="面积" prop="area">
        <el-select v-model="queryParams.area" placeholder="请选择面积" clearable size="small">
          <el-option
            v-for="dict in areaIntervalOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="首付" prop="onePay">
        <el-select v-model="queryParams.onePay" placeholder="请选择首付" clearable size="small">
          <el-option
            v-for="dict in onePayOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="户型" prop="homeType">
        <div style="display: flex">
          <div style="width: 100px">
            <el-select v-model="value1" size="small" placeholder="请选择室">
              <el-option
                v-for="item in options1"
                :key="item.value"
                :label="item.label"
                :value="item.label">
              </el-option>
            </el-select>
          </div>
          <div style="width: 100px">
            <el-select
              v-model="value2"
              size="small"
              collapse-tags

              placeholder="请选择厅">
              <el-option
                v-for="item in options2"
                :key="item.value"
                :label="item.label"
                :value="item.label">
              </el-option>
            </el-select>
          </div>
          <div style="width: 100px">
            <el-select
              v-model="value3"
              size="small"
              collapse-tags
              placeholder="请选择厨">
              <el-option
                v-for="item in options3"
                :key="item.value"
                :label="item.label"
                :value="item.label">
              </el-option>
            </el-select>
          </div>
          <div style="width: 100px">
            <el-select
              v-model="value4"
              size="small"
              collapse-tags
              placeholder="请选择卫">
              <el-option
                v-for="item in options4"
                :key="item.value"
                :label="item.label"
                :value="item.label">
              </el-option>
            </el-select>
          </div>
        </div>
      </el-form-item>
      <el-form-item label="朝向" prop="towards">
        <el-select v-model="queryParams.towards" placeholder="请选择朝向" clearable size="small">
          <el-option
            v-for="dict in towardsOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="装修现状" prop="furnish">
        <el-select v-model="queryParams.furnish" placeholder="请选择装修现状" clearable size="small">
          <el-option
            v-for="dict in furnishOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="装修风格" prop="furnishStyle">
        <el-select v-model="queryParams.furnishStyle" placeholder="请选择装修风格" clearable size="small">
          <el-option
            v-for="dict in furnishStyleOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="装修年限" prop="furnishYear">
        <el-date-picker
          v-model="dateRange"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="电梯/步梯" prop="elevator" label-width="100">
        <el-select v-model="queryParams.elevator" placeholder="请选择电梯/步梯" clearable size="small">
          <el-option
            v-for="dict in elevatorOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="支付方式" prop="payType">
        <el-select v-model="queryParams.payType" placeholder="请选择支付方式" clearable size="small">
          <el-option
            v-for="dict in payTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="忌讳楼层" prop="floor">
        <el-input
          v-model="queryParams.floor"
          placeholder="请输入忌讳楼层"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="备注" prop="note">-->
<!--        <el-input-->
<!--          v-model="queryParams.note"-->
<!--          placeholder="请输入备注"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="到期时间" prop="expireDate">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.expireDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择到期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="其他需求" prop="otherNeed">
        <el-input
          v-model="queryParams.otherNeed"
          placeholder="请输入其他需求"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="客源状态" prop="status">-->
<!--        <el-select v-model="queryParams.status" placeholder="请选择客源状态" clearable size="small">-->
<!--          <el-option-->
<!--            v-for="dict in statusOptions"-->
<!--            :key="dict.dictValue"-->
<!--            :label="dict.dictLabel"-->
<!--            :value="dict.dictValue"-->
<!--          />-->
<!--        </el-select>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="创建时间" prop="createTime">-->
<!--        <el-date-picker clearable size="small" style="width: 200px"-->
<!--                        v-model="queryParams.createTime"-->
<!--                        type="date"-->
<!--                        value-format="yyyy-MM-dd"-->
<!--                        placeholder="选择创建时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="更新时间" prop="updateTime">-->
<!--        <el-date-picker clearable size="small" style="width: 200px"-->
<!--                        v-model="queryParams.updateTime"-->
<!--                        type="date"-->
<!--                        value-format="yyyy-MM-dd"-->
<!--                        placeholder="选择更新时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="备用2" prop="flog2">-->
<!--        <el-input-->
<!--          v-model="queryParams.flog2"-->
<!--          placeholder="请输入备用2"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="备用3" prop="flog3">-->
<!--        <el-input-->
<!--          v-model="queryParams.flog3"-->
<!--          placeholder="请输入备用3"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['houseservice:customerManagement:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['houseservice:customerManagement:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['houseservice:customerManagement:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['houseservice:customerManagement:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="customerManagementList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="id" align="center" prop="id" />-->
<!--      <el-table-column label="公司id" align="center" prop="firmId" />-->
<!--      <el-table-column label="部门id" align="center" prop="deptId" />-->
<!--      <el-table-column label="用户id" align="center" prop="userId" />-->
<!--      <el-table-column label="角色id" align="center" prop="roleId" />-->
<!--      <el-table-column label="客源编号" align="center" prop="customId" />-->
      <el-table-column label="上传者" align="center" prop="uploader" sortable width="100"/>
      <el-table-column label="上传者电话" align="center" prop="uploaderPhone" sortable width="110"/>
      <el-table-column label="公私盘" align="center" prop="gongSiPan"  sortable width="100"/>
      <el-table-column label="客户等级" align="center" prop="customerLever"  sortable width="100"/>
      <el-table-column label="购房目的" align="center" prop="purpose"  sortable width="100"/>
      <el-table-column label="客户姓名1" align="center" prop="name" sortable width="110"/>
      <el-table-column label="联系方式1" align="center" prop="phoneNum" sortable width="110"/>
      <el-table-column label="客户姓名2" align="center" prop="nameOne" sortable width="110"/>
      <el-table-column label="联系方式2" align="center" prop="phoneNumber" sortable width="110"/>
      <el-table-column label="客户性别" align="center" prop="sex"  sortable width="100"/>
      <el-table-column label="区域" align="center" prop="region" sortable width="125"/>
      <el-table-column label="小区" align="center" prop="homeName" sortable width="125"/>
      <el-table-column label="总价" align="center" prop="allPrice"  sortable width="80"/>
      <el-table-column label="面积" align="center" prop="area" sortable width="70"/>
      <el-table-column label="首付" align="center" prop="onePay"  sortable width="80"/>
      <el-table-column label="户型" align="center" prop="homeType"  sortable width="135"/>
      <el-table-column label="朝向" align="center" prop="towards"  sortable width="70"/>
      <el-table-column label="装修现状" align="center" prop="furnish"  sortable width="100"/>
      <el-table-column label="装修风格" align="center" prop="furnishStyle"  sortable width="100"/>
      <el-table-column label="装修年限" align="center" prop="furnishYear" sortable width="105"/>
      <el-table-column label="电梯/步梯" align="center" prop="elevator"  sortable width="100"/>
      <el-table-column label="支付方式" align="center" prop="payType"  sortable width="100"/>
      <el-table-column label="忌讳楼层" align="center" prop="floor" sortable width="100"/>
      <el-table-column label="备注" align="center" prop="note" sortable width="100"/>
      <el-table-column label="到期时间" align="center" prop="expireDate" width="180" sortable >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expireDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="附属设施" align="center" prop="facility"  sortable width="100"/>
<!--      <el-table-column label="其他需求" align="center" prop="otherNeed" />-->
<!--      <el-table-column label="客源状态" align="center" prop="status" :formatter="statusFormat" />-->
      <el-table-column label="创建时间" align="center" prop="createTime" width="180" sortable >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="更新时间" align="center" prop="updateTime" width="180" sortable>
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updateTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
<!--      <el-table-column label="备用2" align="center" prop="flog2" />-->
<!--      <el-table-column label="备用3" align="center" prop="flog3" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['houseservice:customerManagement:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['houseservice:customerManagement:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改客源上传对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="公司id" prop="firmId">-->
<!--          <el-input v-model="form.firmId" placeholder="请输入公司id" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="部门id" prop="deptId">-->
<!--          <el-input v-model="form.deptId" placeholder="请输入部门id" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="用户id" prop="userId">-->
<!--          <el-input v-model="form.userId" placeholder="请输入用户id" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="角色id" prop="roleId">-->
<!--          <el-input v-model="form.roleId" placeholder="请输入角色id" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="客源编号" prop="customId">-->
<!--          <el-input v-model="form.customId" placeholder="请输入客源编号" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="上传者" prop="uploader">-->
<!--          <el-input v-model="form.uploader" placeholder="请输入上传者" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="上传者电话" prop="uploaderPhone">-->
<!--          <el-input v-model="form.uploaderPhone" placeholder="请输入上传者电话" />-->
<!--        </el-form-item>-->
        <el-form-item label="公私盘" prop="gongSiPan">
          <el-select v-model="form.gongSiPan" placeholder="请选择公私盘">
            <el-option
              v-for="dict in gongSiPanOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户等级" prop="customerLever">
          <el-select v-model="form.customerLever" placeholder="请选择客户等级">
            <el-option
              v-for="dict in customerLeverOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="购房目的" prop="purpose">
          <el-select v-model="form.purpose" placeholder="请选择购房目的">
            <el-option
              v-for="dict in purposeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户姓名1" prop="name" label-width="90px">
          <el-input v-model="form.name"  placeholder="请输入客户姓名1" />
        </el-form-item>
        <el-form-item label="联系方式1" prop="phoneNum" label-width="90px">
          <el-input v-model="form.phoneNum" placeholder="请输入联系方式1" />
        </el-form-item>
        <el-form-item label="客户姓名2" prop="nameOne">
          <el-input v-model="form.nameOne" placeholder="请输入客户姓名2" />
        </el-form-item>
        <el-form-item label="联系方式2" prop="phoneNumber">
          <el-input v-model="form.phoneNumber" placeholder="请输入联系方式2" />
        </el-form-item>
        <el-form-item label="客户性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择客户性别">
            <el-option
              v-for="dict in sexOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="区域" prop="region">
          <el-select v-model="form.region" placeholder="请选择区域">
            <el-option
              v-for="dict in housingList"
              :key="dict"
              :label="dict"
              :value="dict"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="小区" prop="homeName">
          <el-select v-model="form.homeName" placeholder="请选择小区">
            <el-option
              v-for="dict in homeList"
              :key="dict"
              :label="dict"
              :value="dict"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="总价" prop="allPrice">
          <el-select v-model="form.allPrice" placeholder="请选择总价">
            <el-option
              v-for="dict in allPriceOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="面积" prop="area">
          <el-select v-model="form.area" placeholder="请选择面积" >
            <el-option
              v-for="dict in areaIntervalOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="首付" prop="onePay">
          <el-select v-model="form.onePay" placeholder="请选择首付">
            <el-option
              v-for="dict in onePayOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="户型" prop="homeType">
          <div style="display: flex">
            <div style="width: 100px">
              <el-select v-model="value1" size="small" placeholder="请选择室">
                <el-option
                  v-for="item in options1"
                  :key="item.value"
                  :label="item.label"
                  :value="item.label">
                </el-option>
              </el-select>
            </div>
            <div style="width: 100px">
              <el-select
                v-model="value2"
                size="small"
                collapse-tags

                placeholder="请选择厅">
                <el-option
                  v-for="item in options2"
                  :key="item.value"
                  :label="item.label"
                  :value="item.label">
                </el-option>
              </el-select>
            </div>
            <div style="width: 100px">
              <el-select
                v-model="value3"
                size="small"
                collapse-tags
                placeholder="请选择厨">
                <el-option
                  v-for="item in options3"
                  :key="item.value"
                  :label="item.label"
                  :value="item.label">
                </el-option>
              </el-select>
            </div>
            <div style="width: 100px">
              <el-select
                v-model="value4"
                size="small"
                collapse-tags
                placeholder="请选择卫">
                <el-option
                  v-for="item in options4"
                  :key="item.value"
                  :label="item.label"
                  :value="item.label">
                </el-option>
              </el-select>
            </div>
          </div>
        </el-form-item>
        <el-form-item label="朝向" prop="towards">
          <el-select v-model="form.towards" placeholder="请选择朝向">
            <el-option
              v-for="dict in towardsOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="装修现状" prop="furnish">
          <el-select v-model="form.furnish" placeholder="请选择装修现状">
            <el-option
              v-for="dict in furnishOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="装修风格" prop="furnishStyle">
          <el-select v-model="form.furnishStyle" placeholder="请选择装修风格">
            <el-option
              v-for="dict in furnishStyleOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="装修年限" prop="furnishYear" style="width: 620px">
          <div style="display: flex">
            <el-input
              style="width: 100px"
              v-model="value5.start"
              placeholder="如2000"
              clearable
              size="small"
              @keyup.enter.native="handleQuery"

            />
            至
            <el-input
              style="width: 100px"
              v-model="value5.end"
              placeholder="2002"
              clearable
              size="small"
              @keyup.enter.native="handleQuery"
            />
            年
          </div>
        </el-form-item>
        <el-form-item label="电梯/步梯" prop="elevator" label-width="90px">
          <el-select v-model="form.elevator" placeholder="请选择电梯/步梯">
            <el-option
              v-for="dict in elevatorOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="付款方式" prop="payType">
          <el-select v-model="form.payType" placeholder="请选择付款方式">
            <el-option
              v-for="dict in payTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="忌讳楼层" prop="floor">
          <el-input v-model="form.floor" placeholder="请输入忌讳楼层,逗号分隔" />
        </el-form-item>
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="到期时间" prop="expireDate">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.expireDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择到期时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="附属设施">
          <el-checkbox-group v-model="form.facility">
            <el-checkbox
              v-for="dict in facilityOptions"
              :key="dict.dictValue"
              :label="dict.dictValue">
              {{dict.dictLabel}}
            </el-checkbox>
          </el-checkbox-group>
        </el-form-item>
<!--        <el-form-item label="其他需求" prop="otherNeed">-->
<!--          <el-input v-model="form.otherNeed" placeholder="请输入其他需求" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="客源状态" prop="status">-->
<!--          <el-select v-model="form.status" placeholder="请选择客源状态">-->
<!--            <el-option-->
<!--              v-for="dict in statusOptions"-->
<!--              :key="dict.dictValue"-->
<!--              :label="dict.dictLabel"-->
<!--              :value="dict.dictValue"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="备用2" prop="flog2">-->
<!--          <el-input v-model="form.flog2" placeholder="请输入备用2" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="备用3" prop="flog3">-->
<!--          <el-input v-model="form.flog3" placeholder="请输入备用3" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCustomerManagement, getCustomerManagement, delCustomerManagement, addCustomerManagement, updateCustomerManagement, exportCustomerManagement } from "@/api/houseservice/customerManagement";
import { listDistric,listHome} from "@/api/houseservice/housing.js";


export default {
  name: "CustomerManagement",
  components: {
  },
  data() {
    return {
      pickerOptions: {
        shortcuts: [{
          text: '本月',
          onClick(picker) {
            picker.$emit('pick', [new Date(), new Date()]);
          }
        }, {
          text: '今年至今',
          onClick(picker) {
            const end = new Date();
            const start = new Date(new Date().getFullYear(), 0);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近六个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setMonth(start.getMonth() - 6);
            picker.$emit('pick', [start, end]);
          }
        }]
      },
      value5: {
        start:'',
        end:''
      },

      options1: [{
        value: '选项1',
        label: '一室'
      },  {
        value: '选项2',
        label: '两室'
      }, {
        value: '选项3',
        label: '三室'
      }, {
        value: '选项4',
        label: '四室'
      }, {
        value: '选项5',
        label: '五室'
      }, {
        value: '选项6',
        label: '六室'
      }, {
        value: '选项7',
        label: '七室'
      },{
        value: '选项8',
        label: '八室'
      }, {
        value: '选项9',
        label: '九室'
      }],
      options2: [{
        value: '选项1',
        label: '无厅'
      },  {
        value: '选项2',
        label: '一厅'
      }, {
        value: '选项3',
        label: '两厅'
      }, {
        value: '选项4',
        label: '三厅'
      }, {
        value: '选项5',
        label: '四厅'
      }, {
        value: '选项6',
        label: '五厅'
      }, {
        value: '选项7',
        label: '六厅'
      },{
        value: '选项8',
        label: '七厅'
      }, {
        value: '选项9',
        label: '八厅'
      },{
        value: '选项10',
        label: '九厅'
      }],
      options3: [{
        value: '选项1',
        label: '无厨'
      },  {
        value: '选项2',
        label: '一厨'
      }, {
        value: '选项3',
        label: '两厨'
      }, {
        value: '选项4',
        label: '三厨'
      }, {
        value: '选项5',
        label: '四厨'
      }, {
        value: '选项6',
        label: '五厨'
      }, {
        value: '选项7',
        label: '六厨'
      },{
        value: '选项8',
        label: '七厨'
      }, {
        value: '选项9',
        label: '八厨'
      },{
        value: '选项10',
        label: '九厨'
      }],
      options4: [{
        value: '选项1',
        label: '无卫'
      },  {
        value: '选项2',
        label: '一卫'
      }, {
        value: '选项3',
        label: '两卫'
      }, {
        value: '选项4',
        label: '三卫'
      }, {
        value: '选项5',
        label: '四卫'
      }, {
        value: '选项6',
        label: '五卫'
      }, {
        value: '选项7',
        label: '六卫'
      },{
        value: '选项8',
        label: '七卫'
      }, {
        value: '选项9',
        label: '八卫'
      },{
        value: '选项10',
        label: '九卫'
      }],
      dateRange: "",
      value1: [],
      value2: [],
      value3: [],
      value4: [],

      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: false,
      // 总条数
      total: 0,
      // 客源上传表格数据
      customerManagementList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 公私盘字典
      gongSiPanOptions: [],
      // 客户等级字典
      customerLeverOptions: [],
      // 购房目的字典
      purposeOptions: [],
      // 客户性别字典
      sexOptions: [],
      // 总价字典
      allPriceOptions: [],
      //面积字典
      areaIntervalOptions:[],
      // 首付字典
      onePayOptions: [],
      // 朝向字典
      towardsOptions: [],
      // 装修现状字典
      furnishOptions: [],
      // 装修风格字典
      furnishStyleOptions: [],
      // 电梯/步梯字典
      elevatorOptions: [],
      // 支付方式字典
      payTypeOptions: [],
      // 附属设施字典
      facilityOptions: [],
      // 客源状态字典
      statusOptions: [],
      //商圈列表
      housingList:[],
      //小区列表
      homeList:[],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        firmId: null,
        deptId: null,
        userId: null,
        roleId: null,
        customId: null,
        uploader: null,
        uploaderPhone: null,
        gongSiPan: null,
        customerLever: null,
        purpose: null,
        name: null,
        phoneNum: null,
        nameOne: null,
        phoneNumber: null,
        sex: null,
        range: null,
        homeName: null,
        allPrice: null,
        area: null,
        onePay: null,
        homeType: null,
        towards: null,
        furnish: null,
        furnishStyle: null,
        furnishYear: null,
        furnishYear1: null,
        elevator: null,
        payType: null,
        floor: null,
        note: null,
        expireDate: null,
        facility: null,
        otherNeed: null,
        status: null,
        flog2: null,
        flog3: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        gongSiPan: [
          { required: true, message: "公私盘不能为空", trigger: "change" }
        ],
        customerLever: [
          { required: true, message: "客户等级不能为空", trigger: "change" }
        ],
        purpose: [
          { required: true, message: "购房目的不能为空", trigger: "change" }
        ],
        name: [
          { required: true, message: "客户姓名1不能为空", trigger: "blur" }
        ],
        phoneNum: [
          { required: true, message: "联系方式1不能为空", trigger: "blur" }
        ],
        sex: [
          { required: true, message: "客户性别不能为空", trigger: "change" }
        ],
        range: [
          { required: true, message: "区域不能为空", trigger: "blur" }
        ],
        homeName: [
          { required: true, message: "小区不能为空", trigger: "blur" }
        ],
        allPrice: [
          { required: true, message: "总价不能为空", trigger: "change" }
        ],
        onePay: [
          { required: true, message: "首付不能为空", trigger: "change" }
        ],
        // homeType: [
        //   { required: true, message: "户型不能为空", trigger: "change" }
        // ],
        towards: [
          { required: true, message: "朝向不能为空", trigger: "change" }
        ],
        furnish: [
          { required: true, message: "装修现状不能为空", trigger: "change" }
        ],
        furnishStyle: [
          { required: true, message: "装修风格不能为空", trigger: "change" }
        ],
        // elevator: [
        //   { required: true, message: "电梯/步梯不能为空", trigger: "change" }
        // ],
        payType: [
          { required: true, message: "支付方式不能为空", trigger: "change" }
        ],
      }
    };
  },
  watch:{
    value1(val, value){
      this.form.homeType = this.value1 + this.value2 + this.value3 +this.value4;
      // console.log(this.queryParams.homeType);
    },
    value2(val, value){
      this.form.homeType = this.value1 + this.value2 + this.value3 +this.value4;
      // console.log(this.queryParams.homeType);
      // console.log("value1变化了");
    },
    value3(val, value){
      this.form.homeType = this.value1 + this.value2 + this.value3 +this.value4;
      // console.log(this.queryParams.homeType);
      // console.log("value1变化了");
    },
    value4(val, value){
      this.form.homeType = this.value1 + this.value2 + this.value3 +this.value4;
      // console.log(this.queryParams.homeType);
      // console.log("value1变化了");
    }
  },

  created() {
    this.getList();
    this.getDicts("sys_public_private").then(response => {
      this.gongSiPanOptions = response.data;
    });
    this.getDicts("sys_customer_lever").then(response => {
      this.customerLeverOptions = response.data;
    });
    this.getDicts("sys_purpose").then(response => {
      this.purposeOptions = response.data;
    });
    this.getDicts("sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });
    this.getDicts("sys_total_need").then(response => {
      this.allPriceOptions = response.data;
    });
    this.getDicts("sys_area").then(response => {
      this.areaIntervalOptions = response.data;
    });
    this.getDicts("sys_first_price").then(response => {
      this.onePayOptions = response.data;
    });
    this.getDicts("sys_towards").then(response => {
      this.towardsOptions = response.data;
    });
    this.getDicts("sys_renovation_status").then(response => {
      this.furnishOptions = response.data;
    });
    this.getDicts("sys_furnish_style").then(response => {
      this.furnishStyleOptions = response.data;
    });
    this.getDicts("sys_elevator").then(response => {
      this.elevatorOptions = response.data;
    });
    this.getDicts("sys_payment_mehods").then(response => {
      this.payTypeOptions = response.data;
    });
    this.getDicts("sys_facility").then(response => {
      this.facilityOptions = response.data;
    });
    this.getDicts("sys_status_is").then(response => {
      this.statusOptions = response.data;
    });
  },
  methods: {
    /** 查询客源上传列表 */
    getList() {
      this.loading = true;
      listCustomerManagement(this.queryParams).then(response => {
        this.customerManagementList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      listDistric().then(response => {
        this.housingList=[];
        response.rows.forEach((item)=>{
          this.housingList.push(item.distric);
        })
        // this.total = response.total;
      });
      listHome().then(response => {
        this.homeList=[];
        // console.log(response)
        response.rows.forEach((item)=>{
          this.homeList.push(item.name);
        })
        // this.total = response.total;
      });
    },
    // // 公私盘字典翻译
    // gongSiPanFormat(row, column) {
    //   return this.selectDictLabel(this.gongSiPanOptions, row.gongSiPan);
    // },
    // // 客户等级字典翻译
    // customerLeverFormat(row, column) {
    //   return this.selectDictLabel(this.customerLeverOptions, row.customerLever);
    // },
    // // 购房目的字典翻译
    // purposeFormat(row, column) {
    //   return this.selectDictLabel(this.purposeOptions, row.purpose);
    // },
    // // 客户性别字典翻译
    // sexFormat(row, column) {
    //   return this.selectDictLabel(this.sexOptions, row.sex);
    // },
    // // 总价字典翻译
    // allPriceFormat(row, column) {
    //   return this.selectDictLabel(this.allPriceOptions, row.allPrice);
    // },
    // // 首付字典翻译
    // onePayFormat(row, column) {
    //   return this.selectDictLabel(this.onePayOptions, row.onePay);
    // },
    // // 朝向字典翻译
    // towardsFormat(row, column) {
    //   return this.selectDictLabel(this.towardsOptions, row.towards);
    // },
    // // 装修现状字典翻译
    // furnishFormat(row, column) {
    //   return this.selectDictLabel(this.furnishOptions, row.furnish);
    // },
    // // 装修风格字典翻译
    // furnishStyleFormat(row, column) {
    //   return this.selectDictLabel(this.furnishStyleOptions, row.furnishStyle);
    // },
    // // 电梯/步梯字典翻译
    // elevatorFormat(row, column) {
    //   return this.selectDictLabel(this.elevatorOptions, row.elevator);
    // },
    // // 支付方式字典翻译
    // payTypeFormat(row, column) {
    //   return this.selectDictLabel(this.payTypeOptions, row.payType);
    // },
    // // 附属设施字典翻译
    // facilityFormat(row, column) {
    //   return this.selectDictLabels(this.facilityOptions, row.facility);
    // },
    // // 客源状态字典翻译
    // statusFormat(row, column) {
    //   return this.selectDictLabel(this.statusOptions, row.status);
    // },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        firmId: null,
        deptId: null,
        userId: null,
        roleId: null,
        customId: null,
        uploader: null,
        uploaderPhone: null,
        gongSiPan: null,
        customerLever: null,
        purpose: null,
        name: null,
        phoneNum: null,
        nameOne: null,
        phoneNumber: null,
        sex: null,
        region: null,
        homeName: null,
        allPrice: null,
        area: null,
        onePay: null,
        homeType: null,
        towards: null,
        furnish: null,
        furnishStyle: null,
        furnishYear: null,
        elevator: null,
        payType: null,
        floor: null,
        note: null,
        expireDate: null,
        facility: [],
        otherNeed: null,
        status: null,
        createTime: null,
        updateTime: null,
        flog2: null,
        flog3: null
      };
      this.value5={
        start:'',
          end:''
      };
        this.value1='',
        this.value2='',
        this.value3='',
        this.value4='',
        this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.queryParams.homeType =  this.value1 + this.value2 + this.value3 + this.value4,
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.value1 = this.value2 = this.value3 = this.value4 = '';
      this.region=null;
      this.homeName=null;
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加客源上传";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCustomerManagement(id).then(response => {
        this.form = response.data;
        this.form.facility = this.form.facility.split(",");
        this.open = true;
        this.title = "修改客源上传";
      });
    },
    /** 提交按钮 */
    submitForm() {
      console.log(this.value5)
      this.form.furnishYear = this.value5.start+"-"+this.value5.end+"年";
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.facility = this.form.facility.join(",");
          if (this.form.id != null) {
            updateCustomerManagement(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCustomerManagement(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除客源上传编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCustomerManagement(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有客源上传数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportCustomerManagement(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
