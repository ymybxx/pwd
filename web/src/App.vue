<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <!-- <router-link to="/login">login</router-link> -->
    
    <router-view/>
    
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
}
</style>
