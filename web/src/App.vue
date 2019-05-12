<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-link to="/login">login</router-link>
    <router-link to="/">/</router-link>
    <router-view/>
    
    <el-footer>
     <!--分页-->
　　<paging></paging>
    </el-footer>
  </div>
</template>

<script>
import paging from '@/components/paging'
//import paging from './components/paging.vue'
export default {
  name: 'App',
  components:{
    paging
  },
  mounted(){
	window.addEventListener('hashchange',()=>{
		var currentPath = window.location.hash.slice(1); // 获取输入的路由
		if(this.$router.path !== currentPath){
			this.$router.push(currentPath); // 动态跳转
		}
	},false);
}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
