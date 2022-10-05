<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="区域" prop="distric">
        <el-input
          v-model="queryParams.distric"
          placeholder="请输入区域,逗号分隔"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="小区名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入小区名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
      <el-form-item label="银行评估值" prop="bankValue" label-width="111">
        <el-input
          v-model="queryParams.bankValue"
          placeholder="请输入银行评估值"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市场价" prop="marketPrice">
        <el-input
          v-model="queryParams.marketPrice"
          placeholder="请输入市场价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="税务单价" prop="taxPrice">
        <el-input
          v-model="queryParams.taxPrice"
          placeholder="请输入税务单价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="贷款比例值" prop="loanValue" label-width="111">
        <el-input
          v-model="queryParams.loanValue"
          placeholder="请输入贷款比例值"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="交房日期" prop="exchangeDate">-->
<!--        <el-date-picker clearable size="small" style="width: 200px"-->
<!--          v-model="queryParams.exchangeDate"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择交房日期">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
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
      <el-form-item >
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
          v-hasPermi="['houseservice:housing:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['houseservice:housing:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['houseservice:housing:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['houseservice:housing:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="housingList" @selection-change="handleSelectionChange" :default-sort = "{prop: 'id', order: 'descending'}">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="区域" align="center" prop="distric" />
      <el-table-column label="小区名称" align="center" prop="name" />
      <el-table-column label="产权性质" align="center" prop="property" :formatter="propertyFormat" />
      <el-table-column label="产证状态" align="center" prop="productStatus" :formatter="productStatusFormat" sortable />
      <el-table-column label="银行评估值" align="center" prop="bankValue" sortable/>
      <el-table-column label="市场价" align="center" prop="marketPrice" sortable/>
      <el-table-column label="税务单价" align="center" prop="taxPrice" sortable/>

      <el-table-column label="贷款比例值" align="center" prop="loanValue" sortable/>
<!--      <el-table-column label="交房日期" align="center" prop="exchangeDate"  sortable width="180">-->

<!--        <template slot-scope="scope">-->
<!--          <span>{{ parseTime(scope.row.exchangeDate, '{y}-{m}-{d}') }}</span>-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['houseservice:housing:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['houseservice:housing:remove']"
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

    <!-- 添加或修改小区对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="区域" prop="distric" label-width="90px">
          <el-input v-model="form.distric" placeholder="请输入区域" />
        </el-form-item>
        <el-form-item label="小区名称" prop="name" width="100" label-width="90px">
          <el-input v-model="form.name" placeholder="请输入小区名称" />
        </el-form-item>

        <el-form-item label="产权性质" prop="property" label-width="90px">
          <el-select v-model="form.property" placeholder="请选择产权性质" style="width:100%">
            <el-option
              v-for="dict in propertyOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产证状态" prop="productStatus" label-width="90px">
          <el-select v-model="form.productStatus" placeholder="请选择产证状态" style="width:100%">
            <el-option
              v-for="dict in productStatusOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <div v-if="form.productStatus !== '无'">
          <el-form-item label="银行评估值" prop="bankValue" label-width="92px">
            <el-input v-model="form.bankValue" placeholder="请输入银行评估值" />
          </el-form-item>
          <el-form-item label="市场价" prop="marketPrice" label-width="90px">
            <el-input v-model="form.marketPrice" placeholder="请输入市场价" />
          </el-form-item>
          <el-form-item label="税务单价" prop="taxPrice" label-width="90px">
            <el-input v-model="form.taxPrice" placeholder="请输入税务单价" />
          </el-form-item>

          <el-form-item label="贷款比例值" prop="loanValue" label-width="92px">
            <el-input v-model="form.loanValue" placeholder="请输入贷款比例值" />
          </el-form-item>
          <!--        <el-form-item label="交房日期" prop="exchangeDate">-->
          <!--          <el-date-picker clearable size="small" style="width: 200px"-->
          <!--            v-model="form.exchangeDate"-->
          <!--            type="date"-->
          <!--            value-format="yyyy-MM-dd"-->
          <!--            placeholder="选择交房日期">-->
          <!--          </el-date-picker> -->
          <!--        </el-form-item>-->

        </div>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listHousing, getHousing, delHousing, addHousing, updateHousing, exportHousing } from "@/api/houseservice/housing";

export default {
  name: "Housing",
  components: {
  },
  data() {
    return {
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
      // 小区表格数据
      housingList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 产权性质字典
      propertyOptions: [],
      // 产证状态字典
      productStatusOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        property: null,
        bankValue: null,
        marketPrice: null,
        taxPrice: null,
        distric: null,
        loanValue: null,
        exchangeDate: null,
        productStatus: null,

      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "小区名称不能为空", trigger: "blur" }
        ],
        property: [
          { required: true, message: "产权性质不能为空", trigger: "change" }
        ],
        bankValue: [
          { required: true, message: "银行评估值不能为空", trigger: "blur" }
        ],
        marketPrice: [
          { required: true, message: "市场价不能为空", trigger: "blur" }
        ],
        taxPrice: [
          { required: true, message: "税务单价不能为空", trigger: "blur" }
        ],
        distric: [
          { required: true, message: "区域不能为空", trigger: "blur" }
        ],
        loanValue: [
          { required: true, message: "贷款比例值不能为空", trigger: "blur" }
        ],
        productStatus: [
          { required: true, message: "产证状态不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("sys_property").then(response => {
      this.propertyOptions = response.data;
    });
    this.getDicts("sys_certificate_status").then(response => {
      this.productStatusOptions = response.data;
    });
  },
  methods: {
    /** 查询小区列表 */
    getList() {
      this.loading = true;
      listHousing(this.queryParams).then(response => {
        this.housingList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },

    // 产权性质字典翻译
    propertyFormat(row, column) {
      return this.selectDictLabel(this.propertyOptions, row.property);
    },
    // 产证状态字典翻译
    productStatusFormat(row, column) {
      return this.selectDictLabel(this.productStatusOptions, row.productStatus);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        property: null,
        bankValue: null,
        marketPrice: null,
        taxPrice: null,
        distric: null,
        loanValue: null,
        exchangeDate: null,
        productStatus: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
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
      this.title = "添加小区";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getHousing(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改小区";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateHousing(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHousing(this.form).then(response => {
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
      this.$confirm('是否确认删除小区编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delHousing(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有小区数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportHousing(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
