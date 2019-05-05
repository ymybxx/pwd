<template>
  <div id="app">
    <img src="./assets/logo.png">
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
