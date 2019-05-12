<template>
  <div id="login">
    <el-form :model="loginForm" :rules="loginRules">
      <h2>Ray商城登录</h2>
      <el-form-item prop="username">
        <el-input
        v-model="loginForm.username"
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
        <el-button type="primary">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'Login',
  props: [""],
  data() {
    return {
        loginForm: {
            username: '',
            password: '',
        },
        loginRules: {
        username: [
            {
                required: true,

                message: "请输入用户名",

                trigger: "blur"
            }
        ],
        password: [
           {
               required: true,
               message: '请输入密码',
               trigger: 'blur'
           }
        ]
      }
    };
  },

  components: {},

  computed: {},

  beforeMount() {},

  mounted() {},

  methods: {},

  watch: {}
};
</script>
<style lang='' scoped>
.el-input {
  width: 300px;
}
</style>