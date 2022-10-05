<template>
  <div class="app-container" >
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="房东姓名1" prop="name" label-width="10">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入房东姓名1"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房东电话1" prop="phoneNum" label-width="10">
        <el-input
          v-model="queryParams.phoneNum"
          placeholder="请输入房东电话1"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房东姓名2" prop="nameOne" label-width="10">
        <el-input
          v-model="queryParams.nameOne"
          placeholder="请输入房东姓名2"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房东电话2" prop="phoneNumber" label-width="10">
        <el-input
          v-model="queryParams.phoneNumber"
          placeholder="请输入房东电话2"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
      <el-form-item label="小区名称" prop="homeName">
        <el-select v-model="queryParams.homeName" placeholder="请选择小区">
          <el-option
            v-for="dict in homeList"
            :key="dict"
            :label="dict"
            :value="dict"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="房源等级" prop="homeLevel">
        <el-select v-model="queryParams.homeLevel" placeholder="请选择房源等级" clearable size="small">
          <el-option
            v-for="dict in homeLevelOptions"
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
      <el-form-item label="产证面积" prop="area">
        <el-input
          v-model="queryParams.area"
          placeholder="请输入产证面积"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总价" prop="allPrice">
        <el-input
          v-model="queryParams.allPrice"
          placeholder="请输入总价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
      <el-form-item label="电梯/步梯" prop="elevator" label-width="10">
        <el-select v-model="queryParams.elevator" placeholder="请选择电梯" clearable size="small">
          <el-option
            v-for="dict in elevatorOptions"
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
      <el-form-item label="装修金额" prop="furnishAmount">
        <el-input
          v-model="queryParams.furnishAmount"
          placeholder="请输入装修金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="装修时间" prop="furnishTime">
        <el-date-picker clearable size="small" style="width: 200px"
                        v-model="queryParams.furnishTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择装修时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="产权性质" prop="property">
        <el-select v-model="queryParams.property" placeholder="请选择产权性质" clearable size="small">
          <el-option
            v-for="dict in propertyOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="产权类型" prop="propertyType">
        <el-select v-model="queryParams.propertyType" placeholder="请选择产权类型" clearable size="small">
          <el-option
            v-for="dict in propertyTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="产证状态" prop="productStatus">
        <el-select v-model="queryParams.productStatus" placeholder="请选择产证状态" clearable size="small">
          <el-option
            v-for="dict in productStatusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="房屋现状" prop="currentStatus">
        <el-select v-model="queryParams.currentStatus" placeholder="请选择房屋现状" clearable size="small">
          <el-option
            v-for="dict in currentStatusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="附属设施" prop="facility">
        <el-select v-model="queryParams.facility" placeholder="请选择附属设施" clearable size="small">
          <el-option
            v-for="dict in facilityOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
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
          v-hasPermi="['houseservice:upload:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['houseservice:upload:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['houseservice:upload:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['houseservice:upload:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" ></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="uploadList" @selection-change="handleSelectionChange" :default-sort = "{prop: 'id', order: 'descending'}">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="上传者" align="center" prop="creater" sortable width="90"/>
      <el-table-column label="上传者电话" align="center" prop="createrNumber" width="110"/>
      <el-table-column label="房源编号" align="center" prop="houseNum" sortable width="115"/>
<!--      <el-table-column label="公私盘" align="center" prop="gongSiPan" :formatter="gongSiPanFormat" sortable width="90"/>-->
      <el-table-column label="房东姓名1" align="center" prop="name" />
      <el-table-column label="房东电话1" align="center" prop="phoneNum" width="110"/>
      <el-table-column label="房东姓名2" align="center" prop="nameOne" />
      <el-table-column label="房东电话2" align="center" prop="phoneNumber" width="110"/>
      <el-table-column label="区域" align="center" prop="region" />
      <el-table-column label="小区名称" align="center" prop="homeName" sortable width="100"/>
      <el-table-column label="栋座" align="center" prop="build" sortable/>
      <el-table-column label="单元" align="center" prop="unit" />
      <el-table-column label="楼层" align="center" prop="floor" />
      <el-table-column label="房号" align="center" prop="roomId" sortable/>
      <el-table-column label="房源等级" align="center" prop="homeLevel"  sortable width="100" />
      <el-table-column label="支付方式" align="center" prop="payType"  />
      <el-table-column label="产证面积" align="center" prop="area" sortable width="110"/>
      <el-table-column label="总价" align="center" prop="allPrice" sortable/>
      <el-table-column label="产证地址" align="center" prop="location" />
      <el-table-column label="户型" align="center" prop="homeType"  sortable/>
      <el-table-column label="朝向" align="center" prop="towards"  sortable />
      <el-table-column label="电梯/步梯" align="center" prop="elevator"  sortable width="110"/>
      <el-table-column label="装修现状" align="center" prop="furnish"  />
      <el-table-column label="装修风格" align="center" prop="furnishStyle"  />
      <el-table-column label="装修金额" align="center" prop="furnishAmount" sortable width="100"/>
      <el-table-column label="装修时间" align="center" prop="furnishTime" sortable width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.furnishTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="产权性质" align="center" prop="property"  />
      <el-table-column label="产权类型" align="center" prop="propertyType"  />
      <el-table-column label="产证状态" align="center" prop="productStatus"  sortable width="100"/>
      <el-table-column label="房屋现状" align="center" prop="currentStatus"  />
      <el-table-column label="状态" align="center" prop="state" />
      <el-table-column label="附属设施" align="center" prop="facility"  />


      <!--      <el-table-column label="户型" align="center" prop="homeType" :formatter="homeTypeFormat" />-->

<!--      -->
<!--      <el-table-column label="底价" align="center" prop="lowPrice" sortable/>-->
<!--      <el-table-column label="首付" align="center" prop="onePay" sortable/>-->
<!--      <el-table-column label="产权状态" align="center" prop="propertyStatus" />-->
<!--      <el-table-column label="特殊需求" align="center" prop="specialNeed"  />-->
<!--      <el-table-column label="创建时间" align="center" prop="createTime" width="100" sortable>-->
<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.createTime) }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="更新时间" align="center" prop="updateTime" sortable width="100"/>-->

<!--      <el-table-column label="门店" align="center" prop="storeFront" />-->
<!--      <el-table-column label="图片" align="center" prop="picOne" >-->
<!--        <template slot-scope="scope" >-->
<!--          <el-image-->
<!--            style="width: 100px; height: 100px"-->
<!--            :src="scope.row.picOne"-->
<!--          ></el-image>-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['houseservice:upload:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['houseservice:upload:remove']"
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

    <!-- 添加或修改房源上传对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="公私盘" prop="gongSiPan">-->
<!--          <el-select v-model="form.gongSiPan" placeholder="请选择公私盘">-->
<!--            <el-option-->
<!--              v-for="dict in gongSiPanOptions"-->
<!--              :key="dict.dictValue"-->
<!--              :label="dict.dictLabel"-->
<!--              :value="dict.dictValue"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item label="房东姓名1" prop="name" label-width="90px">
          <el-input v-model="form.name" placeholder="请输入房东姓名" />
        </el-form-item>
        <el-form-item label="房东电话1" prop="phoneNum" label-width="90px">
          <el-input v-model="form.phoneNum" placeholder="请输入房东电话" />
        </el-form-item>
        <el-form-item label="房东姓名2" prop="nameOne">
          <el-input v-model="form.nameOne" placeholder="请输入房东姓名1" />
        </el-form-item>
        <el-form-item label="房东电话2" prop="phoneNumber">
          <el-input v-model="form.phoneNumber" placeholder="请输入房东电话1" />
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
        <el-form-item label="小区名称" prop="homeName">
          <el-select v-model="form.homeName" placeholder="请选择小区">
            <el-option
              v-for="dict in homeList"
              :key="dict"
              :label="dict"
              :value="dict"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="栋座" prop="build">
          <el-input v-model="form.build" placeholder="请输入栋座" />
        </el-form-item>
        <el-form-item label="单元" prop="unit">
          <el-input v-model="form.unit" placeholder="请输入单元" />
        </el-form-item>
        <el-form-item label="楼层" prop="floor">
          <el-input v-model="form.floor" placeholder="请输入楼层" />
        </el-form-item>
        <el-form-item label="房号" prop="roomId">
          <el-input v-model="form.roomId" placeholder="请输入房号" />
        </el-form-item>
        <el-form-item label="房源等级" prop="homeLevel">
          <el-select v-model="form.homeLevel" placeholder="请选择房源等级" style="width:100%">
            <el-option
              v-for="dict in homeLevelOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="支付方式" prop="payType">
          <el-select v-model="form.payType" placeholder="请选择支付方式" style="width:100%">
            <el-option
              v-for="dict in payTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产证面积" prop="area">
          <el-input v-model="form.area"  placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="总价" prop="allPrice">
          <el-input v-model="form.allPrice" placeholder="请输入总价" />
        </el-form-item>
        <el-form-item label="产证地址" prop="location">
          <el-input v-model="form.location" placeholder="请输入产证地址" />
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
          <el-select v-model="form.towards" placeholder="请选择朝向" style="width:100%">
            <el-option
              v-for="dict in towardsOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="电梯/步梯" prop="elevator">
          <el-select v-model="form.elevator" placeholder="请选择电梯" style="width:100%">
            <el-option
              v-for="dict in elevatorOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="装修现状" prop="furnish">
          <el-select v-model="form.furnish" placeholder="请选择装修现状" style="width:100%">
            <el-option
              v-for="dict in furnishOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="装修风格" prop="furnishStyle">
          <el-select v-model="form.furnishStyle" placeholder="请选择装修风格" style="width:100%">
            <el-option
              v-for="dict in furnishStyleOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="装修金额" prop="furnishAmount">
          <el-input v-model="form.furnishAmount" placeholder="请输入装修金额" />
        </el-form-item>
        <el-form-item label="装修时间" prop="furnishTime">
          <el-date-picker clearable size="small" style="width: 380px"
                          v-model="form.furnishTime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择装修时间"  >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="产权性质" prop="property">
          <el-select v-model="form.property" placeholder="请选择产权性质" style="width:100%">
            <el-option
              v-for="dict in propertyOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产权类型" prop="propertyType">
          <el-select v-model="form.propertyType" placeholder="请选择产权类型" style="width:100%">
            <el-option
              v-for="dict in propertyTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产证状态" prop="productStatus">
          <el-select v-model="form.productStatus" placeholder="请选择产证状态" style="width:100%">
            <el-option
              v-for="dict in productStatusOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="房屋现状" prop="currentStatus">
          <el-select v-model="form.currentStatus" placeholder="请选择房屋现状" style="width:100%">
            <el-option
              v-for="dict in currentStatusOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="状态" prop="state">-->
<!--                    <el-select v-model="form.state" placeholder="请选择状态">-->
<!--                      <el-option-->
<!--                        v-for="dict in stateOptions"-->
<!--                        :key="dict.dictValue"-->
<!--                        :label="dict.dictLabel"-->
<!--                        :value="dict.dictValue"-->
<!--                      ></el-option>-->
<!--                    </el-select>-->
<!--                  </el-form-item>-->
        <el-form-item label="备注" prop="note">
          <el-input v-model="form.note" placeholder="请输入备注" />
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
<!--        <el-form-item label="房龄" prop="roomAge">-->
<!--          <el-input v-model="form.roomAge" placeholder="请输入房龄" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="底价" prop="lowPrice">-->
<!--          <el-input v-model="form.lowPrice" placeholder="请输入底价" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="首付" prop="onePay">-->
<!--          <el-input v-model="form.onePay" placeholder="请输入首付" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="产权状态" prop="propertyStatus">-->
<!--          <el-select v-model="form.propertyStatus" placeholder="请选择产权状态">-->
<!--            <el-option-->
<!--              v-for="dict in propertyStatusOptions"-->
<!--              :key="dict.dictValue"-->
<!--              :label="dict.dictLabel"-->
<!--              :value="dict.dictValue"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->

        <!--        <el-form-item label="状态" prop="state">-->
        <!--          <el-select v-model="form.state" placeholder="请选择状态">-->
        <!--            <el-option-->
        <!--              v-for="dict in stateOptions"-->
        <!--              :key="dict.dictValue"-->
        <!--              :label="dict.dictLabel"-->
        <!--              :value="dict.dictValue"-->
        <!--            ></el-option>-->
        <!--          </el-select>-->
        <!--        </el-form-item>-->
<!--        <el-form-item label="特殊需求">-->
<!--          <el-checkbox-group v-model="form.specialNeed">-->
<!--            <el-checkbox-->
<!--              v-for="dict in specialNeedOptions"-->
<!--              :key="dict.dictValue"-->
<!--              :label="dict.dictValue">-->
<!--              {{dict.dictLabel}}-->
<!--            </el-checkbox>-->
<!--          </el-checkbox-group>-->
<!--        </el-form-item>-->
        <el-form-item label="图片" >
          <uploadImage v-model="form.picOne" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import { listUpload, getUpload, delUpload, addUpload, updateUpload, exportUpload } from "@/api/houseservice/upload";
  import UploadImage from '@/components/UploadImage';
  import { listDistric,listHome} from "@/api/houseservice/housing.js";
  export default {
    name: "Upload",
    components: {
      UploadImage,
    },
    data() {
      return {

        //   fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
        //   url: ''

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
        // 房源上传表格数据
        uploadList: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 房源等级字典
        homeLevelOptions: [],
        // 装修风格字典
        furnishStyleOptions: [],
        // 产权性质字典
        propertyOptions: [],
        // 产权类型字典
        propertyTypeOptions: [],
        // 房屋现状字典
        currentStatusOptions: [],
        // 公私盘字典
        gongSiPanOptions: [],
        // 电梯字典
        elevatorOptions: [],
        // 产证状态字典
        productStatusOptions: [],
        // 户型字典
        homeTypeOptions: [],
        // 产权状态字典
        propertyStatusOptions: [],
        // 装修字典
        furnishOptions: [],
        // 朝向字典
        towardsOptions: [],
        // 支付方式字典
        payTypeOptions: [],
        // 附属设施字典
        facilityOptions: [],
        // 状态字典
        stateOptions: [],
        // 特殊需求字典
        specialNeedOptions: [],
        //商圈列表
        housingList:[],
        //小区列表
        homeList:[],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          houseNum: null,
          gongSiPan: null,
          name: null,
          phoneNum: null,
          homeName: null,

          roomAge: null,
          elevator: null,
          productStatus: null,

          homeType: null,
          area: null,
          allPrice: null,
          lowPrice: null,
          onePay: null,
          propertyStatus: null,
          furnish: null,
          towards: null,
          payType: null,
          facility: null,
          specialNeed: null,

          broker: null,
          creater: null,
          createrNumber: null,
          nameOne: null,
          phoneNumber: null,
          region: null,
          homeLevel: null,
          location: null,
          furnishStyle: null,
          furnishAmount: null,
          furnishTime: null,
          property: null,
          propertyType: null,
          currentStatus: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          gongSiPan: [
            { required: true, message: "公私盘不能为空", trigger: "change" }
          ],
          name: [
            { required: true, message: "房东姓名不能为空", trigger: "blur" }
          ],
          phoneNum: [
            { required: true, message: "房东电话不能为空", trigger: "blur" }
          ],
          homeName: [
            { required: true, message: "小区名称不能为空", trigger: "blur" }
          ],
          build: [
            { required: true, message: "栋座不能为空", trigger: "blur" }
          ],
          unit: [
            { required: true, message: "单元不能为空", trigger: "blur" }
          ],
          floor: [
            { required: true, message: "楼层不能为空", trigger: "blur" }
          ],
          roomId: [
            { required: true, message: "房号不能为空", trigger: "blur" }
          ],
          homeType: [
            { required: true, message: "户型不能为空", trigger: "change" }
          ],
          area: [
            { required: true, message: "面积不能为空", trigger: "blur" }
          ],
          allPrice: [
            { required: true, message: "总价不能为空", trigger: "blur" }
          ],
          lowPrice: [
            { required: true, message: "底价不能为空", trigger: "blur" }
          ],
          onePay: [
            { required: true, message: "首付不能为空", trigger: "blur" }
          ],
          propertyStatus: [
            { required: true, message: "产权状态不能为空", trigger: "change" }
          ],
          furnish: [
            { required: true, message: "装修不能为空", trigger: "change" }
          ],
          towards: [
            { required: true, message: "朝向不能为空", trigger: "change" }
          ],
          payType: [
            { required: true, message: "支付方式不能为空", trigger: "change" }
          ],
          facility: [
            { required: true, message: "附属设施不能为空", trigger: "change" }
          ],

        }
      };

    },
    watch:{
      value1(val, value){
        this.form.homeType = this.value1 + this.value2 + this.value3 +this.value4;
        console.log(this.queryParams.homeType);
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
      this.getDicts("sys_home_level").then(response => {
        this.homeLevelOptions = response.data;
      });
      this.getDicts("sys_furnish_style").then(response => {
        this.furnishStyleOptions = response.data;
      });
      this.getDicts("sys_property").then(response => {
        this.propertyOptions = response.data;
      });
      this.getDicts("sys_property_type").then(response => {
        this.propertyTypeOptions = response.data;
      });
      this.getDicts("sys_current_status").then(response => {
        this.currentStatusOptions = response.data;
      });
      this.getDicts("sys_elevator").then(response => {
        this.elevatorOptions = response.data;
      });
      this.getDicts("sys_certificate_status").then(response => {
        this.productStatusOptions = response.data;
      });
      this.getDicts("sys_public_private").then(response => {
        this.gongSiPanOptions = response.data;
      });
      this.getDicts("sys_home_type").then(response => {
        this.homeTypeOptions = response.data;
      });

      this.getDicts("sys_elevator").then(response => {
        this.elevatorOptions = response.data;
      });
      this.getDicts("sys_certificate_status").then(response => {
        this.productStatusOptions = response.data;
      });

      this.getDicts("sys_property_status").then(response => {
        this.propertyStatusOptions = response.data;
      });
      this.getDicts("sys_renovation_status").then(response => {
        this.furnishOptions = response.data;
      });
      this.getDicts("sys_towards").then(response => {
        this.towardsOptions = response.data;
      });
      this.getDicts("sys_payment_mehods").then(response => {
        this.payTypeOptions = response.data;
      });
      this.getDicts("sys_facility").then(response => {
        this.facilityOptions = response.data;
      });
      this.getDicts("sys_status").then(response => {
        this.stateOptions = response.data;
      });
      this.getDicts("sys_special_need").then(response => {
        this.specialNeedOptions = response.data;
      });
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      },
      to(e) {
        console.log(e);
      },
      /** 查询房源上传列表 */
      getList() {
        this.loading = true;
        listUpload(this.queryParams).then(response => {
          this.uploadList = response.rows;
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
      // // 房源等级字典翻译
      // homeLevelFormat(row, column) {
      //   return this.selectDictLabel(this.homeLevelOptions, row.homeLevel);
      // },
      // // 装修风格字典翻译
      // furnishStyleFormat(row, column) {
      //   return this.selectDictLabel(this.furnishStyleOptions, row.furnishStyle);
      // },
      // // 产权性质字典翻译
      // propertyFormat(row, column) {
      //   return this.selectDictLabel(this.propertyOptions, row.property);
      // },
      // // 产权类型字典翻译
      // propertyTypeFormat(row, column) {
      //   return this.selectDictLabel(this.propertyTypeOptions, row.propertyType);
      // },
      // // 房屋现状字典翻译
      // currentStatusFormat(row, column) {
      //   return this.selectDictLabel(this.currentStatusOptions, row.currentStatus);
      // },
      // // 公私盘字典翻译
      // gongSiPanFormat(row, column) {
      //   return this.selectDictLabel(this.gongSiPanOptions, row.gongSiPan);
      // },
      //
      // // 电梯字典翻译
      // elevatorFormat(row, column) {
      //   return this.selectDictLabel(this.elevatorOptions, row.elevator);
      // },
      // // 产证状态字典翻译
      // productStatusFormat(row, column) {
      //   return this.selectDictLabel(this.productStatusOptions, row.productStatus);
      // },
      //
      // // 户型字典翻译
      // homeTypeFormat(row, column) {
      //   return this.selectDictLabel(this.homeTypeOptions, row.homeType);
      // },
      // // 产权状态字典翻译
      // // propertyStatusFormat(row, column) {
      // //   return this.selectDictLabel(this.propertyStatusOptions, row.propertyStatus);
      // // },
      // // 装修字典翻译
      // furnishFormat(row, column) {
      //   return this.selectDictLabel(this.furnishOptions, row.furnish);
      // },
      // // 朝向字典翻译
      // towardsFormat(row, column) {
      //   return this.selectDictLabel(this.towardsOptions, row.towards);
      // },
      // // 支付方式字典翻译
      // payTypeFormat(row, column) {
      //   return this.selectDictLabel(this.payTypeOptions, row.payType);
      // },
      //
      // // 附属设施字典翻译
      // facilityFormat(row, column) {
      //   return this.selectDictLabels(this.facilityOptions, row.facility);
      // },
      // // 状态字典翻译
      // stateFormat(row, column) {
      //   return this.selectDictLabel(this.stateOptions, row.state);
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
          userId: null,
          departId: null,
          companyId: null,
          roleId: null,
          gongSiPan: null,
          name: null,
          phoneNum: null,
          homeName: null,


          roomAge: null,
          elevator: null,
          productStatus: null,

          build: null,
          unit: null,
          floor: null,
          roomId: null,
          homeType: null,
          area: null,
          allPrice: null,
          lowPrice: null,
          onePay: null,
          propertyStatus: null,
          furnish: null,
          towards: null,
          payType: null,
          facility: [],
          state: null,
          // specialNeed: [],
          picOne: null,
          picTwo: null,
          picThree: null,
          note: null,
          readyOne: null,
          readyTwo: null,
          nameOne: null,
          phoneNumber: null,
          region: null,
          homeLevel: null,
          location: null,
          furnishStyle: null,
          furnishAmount: null,
          furnishTime: null,
          property: null,
          propertyType: null,
          currentStatus: null
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
        this.title = "添加房源上传";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getUpload(id).then(response => {
          this.form = response.data;
          this.form.facility = this.form.facility.split(",");
          // this.form.specialNeed = this.form.specialNeed.split(",");
          this.open = true;
          this.title = "修改房源上传";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            this.form.facility = this.form.facility.join(",");
            if (this.form.id != null) {
              updateUpload(this.form).then(response => {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addUpload(this.form).then(response => {
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
        this.$confirm('是否确认删除房源上传编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delUpload(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有房源上传数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportUpload(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
      }
    }
  };
</script>
