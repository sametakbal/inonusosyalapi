<template>
  <router-view/>
</template>
<script>
import { socialvue } from './config/pluginInit'

export default {
  name: 'App',
  components: {
  },
  mounted () {
    socialvue.mainIndex()
  }
}
</script>
<style lang="scss">
  @import "assets/scss/style.scss";
</style>
