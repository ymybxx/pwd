<template>
  <div id="login">
    <el-form :model="loginForm" :rules="loginRules">
      <h2>欢迎登陆</h2>
      <el-form-item prop="username">
        <el-input
        v-model="loginForm.userName"
          name="username"
          placeholder="请输入用户名/手机号"
          auto-complete="on"
        ></el-input>
      </el-form-item>

      <el-form-item prop="password">
        <el-input
        v-model="loginForm.password"
          name="password"
          placeholder="请输入密码"
          auto-complete="on"
        ></el-input>
      </el-form-item>

      <el-form-item>
        <el-button v-on:click="login()" type="primary">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  props: [""],
  data() {
    return {
      loginForm: {
        userName: "",
        password: ""
      },
      loginRules: {
        userName: [
          {
            required: true,

            message: "请输入用户名",

            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            message: "请输入密码",
            trigger: "blur"
          }
        ]
      }
    };
  },

  components: {},

  computed: {},

  beforeMount() {},

  mounted() {},

  methods: {
    login() {
      this.$axios({
        method: "post",
        url: "api/login",
        data: this.loginForm
      }).then(response => {
        let loginVue = response.data.data
        if (!loginVue.success) {
          //alert(response.data.message)
        } else {
          console.log(this.loginForm.userName)
          localStorage.setItem("userName", this.loginForm.userName);
          localStorage.setItem("token", loginVue.token);
          alert(response.data.message);
          this.$router.push({ name: "Index" });
        }
      });
    }
  },

  watch: {}
};
</script>
<style lang='css' scoped>
.el-input {
  width: 300px;
}

#login {
  background: url("../assets/login_back.jpg");
  background-size: 100% 100%;
  height: 100%;
  position: fixed;
  width: 100%;
  text-align: center;
}

.el-form-item {
  text-align: center;
}
</style>