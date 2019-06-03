<template>
    <el-menu
  router
  :default-active="activeIndex2"
  class="el-menu-demo"
  mode="horizontal"
  @select="handleSelect"
  background-color="#545c64"
  text-color="#fff"
  active-text-color="#ffd04b">
  <el-menu-item index="1"><router-link to="/index">首页</router-link></el-menu-item>
  <el-menu-item index="2">论坛</el-menu-item>
  
  <el-menu-item :index="loginUrl" style="float:right">{{loginStatus}}</el-menu-item>
  <el-menu-item index="4" style="float:right">消息</el-menu-item>
</el-menu>

</template>

<script>
  export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1',
        loginStatus:'',
        loginUrl:''
      };
    },
    mounted(){
        let userName = localStorage.getItem('userName')
        this.judgeLoginStatus(userName)
    },

    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      
      judgeLoginStatus(userName){
          if(!userName) this.setLoginFeature(false)
          this.$axios({
              method: 'post',
              url: 'api/isLogin',
              data: {
                  userName: userName,
                  token: localStorage.getItem('token')
              }
          }).then(response=>{
              if(response.data.data){
                  this.setLoginFeature(userName)
              }else{
                  this.setLoginFeature(false)
              }
          })
      },

      setLoginFeature(username){
        if(!username){
            this.loginStatus = '登录'
            this.loginUrl = '/login'
        }else{
            this.loginStatus = username
            this.loginUrl = '/userinfo/yyx'
        }
      }
    }
  }
</script>

<style lang="" scoped>

</style>