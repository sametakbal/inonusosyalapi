<template>
    <b-row class="row-eq-height">
      <b-col md="12">
        <b-row>
          <b-col md="12">
            <ComposeBody />
          </b-col>
        </b-row>
      </b-col>
    </b-row>
</template>
<script>
import ComposeBody from './ComposeBody'
import { socialvue } from '../../../config/pluginInit'
export default {
  name: 'EmailCompose',
  components: { ComposeBody },
  mounted () {
    socialvue.index()
  }
}
</script>
