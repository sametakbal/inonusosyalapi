<template>
    <b-collapse tag="ul" :class="className" :visible="open" :id="idName" :accordion="accordianName">
        <li v-for="(item,index) in items" :key="index" :class="item.is_heading ? 'iq-menu-title' :activeLink(item) && item.children ? 'active' : activeLink(item) ? 'active' : ''">
          <i v-if="item.is_heading" class="ri-subtract-line" />
            <span v-if="item.is_heading">{{ $t(item.name) }}</span>
            <router-link :to="item.link" v-if="!item.is_heading" :class="`iq-waves-effect ${activeLink(item) && item.children ? 'active' : activeLink(item) ? 'active' : ''}`" v-b-toggle="item.name">
              <i :class="item.icon" v-if="item.is_icon_class"/>
              <template v-else v-html="item.icon">
              </template>
              <span>{{ $t(item.name) }}</span>
              <i v-if="item.children" class="ri-arrow-right-s-line iq-arrow-right" />
              <small v-html="item.append" :class="item.append_class" />
            </router-link>
            <List v-if="item.children" :items="item.children" :open="item.link.name !== '' && activeLink(item) && item.children ? true : !!(item.link.name !== '' && activeLink(item))" :idName="item.name" :accordianName="`sidebar-accordion${item.class_name}`" :className="`iq-submenu ${item.class_name}`" />
        </li>
    </b-collapse>
</template>
<script>
import List from './ListStyle1'
import { socialvue } from '../../../config/pluginInit'
export default {
  name: 'List',
  props: {
    items: Array,
    className: { type: String, default: 'iq-menu' },
    horizontal: Boolean,
    open: { type: Boolean, default: false },
    idName: { type: String, default: 'sidebar' },
    accordianName: { type: String, default: 'sidebar' }
  },
  components: {
    List
  },
  mounted () {
  },
  methods: {
    activeLink (item) {
      return socialvue.getActiveLink(item, this.$route.name)
    }
  }
}
</script>
