<template>
  <div></div>
</template>
<script>
import { socialvue } from '../../config/pluginInit'

export default {
  name: 'BlankPage',
  mounted () {
    socialvue.index()
  }
}
</script>
