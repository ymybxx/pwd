<template>
  <navigation></navigation>
</template>

<script>
  import navigation from "@/components/navigation";
  export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1',
        loginStatus:'',
        loginUrl:''
      };
    },
    components:{
        navigation
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