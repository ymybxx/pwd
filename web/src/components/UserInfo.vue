<template>
  <div>
    <navigation></navigation>
    <el-container>
      <el-container>
        <el-aside width="150px" height="1000px">
          <el-menu
            class="el-menu-demo"
            mode="vertical"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-menu-item index="1">个人中心</el-menu-item>
            <el-menu-item index="2">分析记录</el-menu-item>
            <el-menu-item index="3">发帖记录</el-menu-item>
          </el-menu>
        </el-aside>
        <el-main height="">
          <el-row>
            <el-col :span="24"
              ><div class="grid-content bg-purple-dark">
                欢迎 {{ userName }}
              </div></el-col
            >
          </el-row>
          <el-row>
            <el-col :span="12"
              ><div class="grid-content bg-purple">邮箱：</div></el-col
            >
            <el-col :span="12"
              ><div class="grid-content bg-purple-light">
                {{ userInfo.email }}
              </div></el-col
            >
          </el-row>
          <el-row>
            <el-col :span="12"
              ><div class="grid-content bg-purple">手机：</div></el-col
            >
            <el-col :span="12"
              ><div class="grid-content bg-purple-light">
                {{ userInfo.phone }}
              </div></el-col
            >
          </el-row>
          <el-row>
            <el-col :span="24"
              ><el-button type="text" @click="openEdit()"
                >修改资料</el-button
              ></el-col
            >
            <el-dialog title="修改资料" :visible.sync="editFormVisible">
              <el-form>
                <el-form-item label="邮箱">
                  <el-input
                    v-model="editUserInfo.email"
                    autocomplete="off"
                  ></el-input>
                </el-form-item>
                <el-form-item label="手机">
                  <el-input
                    v-model="editUserInfo.phone"
                    autocomplete="off"
                  ></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="editFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitChange()"
                  >确 定</el-button
                >
              </div>
            </el-dialog>
          </el-row>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import navigation from "@/components/navigation";
export default {
  data() {
    return {
      userName: this.$route.params.userName,
      userInfo: {
        email: "",
        phone: ""
      },
      editUserInfo: {
        email: "",
        phone: ""
      },
      editFormVisible: false
    };
  },
  mounted() {
    this.getUserInfo();
  },
  components: {
    navigation
  },
  methods: {
    getUserInfo() {
      this.$axios({
        method: "post",
        url: "/api/userInfo/get",
        data: {
          userName: this.userName
        }
      }).then(response => {
        let userInfo = response.data.data;
        console.log(userInfo);
        this.userInfo.email = userInfo.email;
        this.userInfo.phone = userInfo.phone;
      });
    },
    openEdit() {
      this.editFormVisible = true;
      this.editUserInfo.userName = this.userName
      this.editUserInfo.email = this.userInfo.email;
      this.editUserInfo.phone = this.userInfo.phone;
    },
    submitChange() {
      this.editFormVisible = false;
      if (
        this.editUserInfo.email == this.userInfo.email &&
        this.editUserInfo.phone == this.userInfo.phone
      ) {
        return;
      } else {
        this.$axios({
          method: "post",
          url: "/api/userInfo/edit",
          data: this.editUserInfo
        }).then(response => {
          if (response.data.data) {
            this.userInfo.email = this.editUserInfo.email;
            this.userInfo.phone = this.editUserInfo.phone;
          }
        });
      }
    }
  }
};
</script>

<style lang="" scoped>
.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>