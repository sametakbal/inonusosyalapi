<template>
  <!-- Right Sidebar Panel Start-->
  <div :class="`right-sidebar-mini `+miniClass">
    <div class="right-sidebar-panel p-0">
        <div class="iq-card shadow-none">
          <div class="iq-card-body p-0">
          <!-- chat and theme button!-->
            <div class="iq-customizer-btn p-3">
              <div class="btn-group w-100" role="group" aria-label="Basic example">
                <button class="btn-chat-data btn" :class="showChat ? 'active' : ''" @click="showChat = true">Chat</button>

                <button class="btn-customizer-data btn" :class="!showChat ? 'active' : ''" @click="showChat = false">
                  Theme customizer
                </button>
              </div>

            </div>
            <!-- chat!-->
            <div class="media-height iq-chat-data-block active-block p-3" v-show="showChat">
                <div v-for="(item,index) in users" :key="index" class="media align-items-center mb-4">
                    <div class="iq-profile-avatar status-online">
                      <img class="rounded-circle avatar-50" :src="item.img" alt="">
                    </div>
                    <div class="media-body ml-3">
                      <h6 class="mb-0"><a href="#">{{item.name}}</a></h6>
                      <p class="mb-0">{{item.time}}</p>
                    </div>
                </div>
               </div>
            <!-- customization !-->
            <iq-card class="shadow-none iq-customizer-block active-block" v-show="!showChat">
              <template v-slot:body>
                <b-row>
                  <div class=" mt-4 mb-4 w-100" />
                  <b-col cols="12" class="justify-content-between">
                    <h4 class="text-left mb-2">{{ $t('customizer.colorMode') }}</h4>
                    <div class="text-center d-flex">
                      <img :src="require('../../../assets/images/customizer/light.jpg')" alt="light" @click="themeMode(false)" class="img-fluid" style="height: 120px;border: 2px solid var(--iq-primary)">
                      <img :src="require('../../../assets/images/customizer/dark.jpg')" alt="dark" @click="themeMode(true)" class="img-fluid ml-2" style="height: 120px;border: 2px solid var(--iq-primary)">
                    </div>
                  </b-col>
                  <div class="border mt-4 mb-4 w-100" />
                  <b-col cols="12" class="justify-content-between">
                    <h4 class="text-left mb-2">{{ $t('customizer.rtlMode')}}</h4>
                    <div class="text-center d-flex">
                      <img :src="require('../../../assets/images/customizer/rtl.jpg')" alt="ltr" @click="rtlChange(true)" class="img-fluid" style="height: 120px;border: 2px solid var(--iq-primary)">
                      <img :src="require('../../../assets/images/customizer/rtl.jpg')" alt="rtl" @click="rtlChange(false)" class="img-fluid ml-2" style="height: 120px;border: 2px solid var(--iq-primary)">
                    </div>
                  </b-col>
                </b-row>
              </template>
            </iq-card>
            <!-- toogle!-->
            <div class="right-sidebar-toggle bg-primary mt-3" @click="toggleMini">
                <i class="ri-arrow-left-line side-left-icon"></i>
                <i class="ri-arrow-right-line side-right-icon"><span class="ml-3 d-inline-block">Close Menu</span></i>
              </div>
          </div>
        </div>

    </div>
  </div>
  <!-- Right Sidebar Panel End-->
</template>
<script>
import loader from '../../../assets/images/logo.png'
import darkLoader from '../../../assets/images/logo-white.png'
import { mapActions } from 'vuex'
export default {
  name: 'RightSideBarStyle1',
  data () {
    return {
      miniClass: '',
      showChat: true,
      animated: { enter: 'zoomIn', exit: 'zoomOut' },
      animateClass: [
        { value: { enter: 'zoomIn', exit: 'zoomOut' }, text: 'Zoom' },
        { value: { enter: 'fadeInUp', exit: 'fadeOutDown' }, text: 'Fade' },
        { value: { enter: 'slideInLeft', exit: 'slideOutRight' }, text: 'Slide' },
        { value: { enter: 'rotateInDownLeft', exit: 'rotateOutDownLeft' }, text: 'Roll' }
      ],
      logo: loader,
      rtl: false,
      users: [
        {
          img: require('../../../assets/images/user/01.jpg'),
          name: 'Anna Sthesia',
          time: 'Just now'
        },
        {
          img: require('../../../assets/images/user/02.jpg'),
          name: 'Paul Molive',
          time: 'Admin'
        },
        {
          img: require('../../../assets/images/user/03.jpg'),
          name: 'Anna Mull',
          time: 'Admin'
        },
        {
          img: require('../../../assets/images/user/04.jpg'),
          name: 'Paige Turner',
          time: 'Admin'
        },
        {
          img: require('../../../assets/images/user/05.jpg'),
          name: 'Bob Frapples',
          time: 'Admin'
        },
        {
          img: require('../../../assets/images/user/06.jpg'),
          name: 'Barb Ackue',
          time: 'Admin'
        },
        {
          img: require('../../../assets/images/user/07.jpg'),
          name: 'Greta Life',
          time: 'Admin'
        },
        {
          img: require('../../../assets/images/user/08.jpg'),
          name: 'ra Membrit',
          time: 'Admin'
        },
        {
          img: require('../../../assets/images/user/09.jpg'),
          name: 'Pete Sariya',
          time: 'Admin'
        },
        {
          img: require('../../../assets/images/user/10.jpg'),
          name: 'ra Membrit',
          time: 'Admin'
        }
      ]
    }
  },
  props: {
    toggleClass: { type: String, default: '' }
  },
  computed: {
    hasIconSlot () {
      return !!this.$slots.icon
    },
    hasOpenIconSlot () {
      return !!this.$slots.openIcon
    },
    hasCloseIconSlot () {
      return !!this.$slots.closeIcon
    }
  },
  methods: {
    toggleMini () {
      this.rightSideBarMini = !this.rightSideBarMini
      this.checkRightSideBar()
    },
    checkRightSideBar () {
      if (this.rightSideBarMini) {
        this.miniClass = 'right-sidebar'
      } else {
        this.miniClass = ''
      }
    },
    themeMode (mode) {
      this.dark = mode
      this.modeChange({ rtl: this.rtl, dark: mode })
      if (mode) {
        this.logo = darkLoader
      } else {
        this.logo = loader
      }
      this.$emit('onLogo', this.logo)
    },
    rtlChange (mode) {
      this.rtl = mode
      this.modeChange({ rtl: mode, dark: this.darkMode })
      if (this.darkMode) {
        this.logo = darkLoader
      } else {
        this.logo = loader
      }
    },
    reset () {
      this.animated = { enter: 'zoomIn', exit: 'zoomOut' }
      this.themeMode(false)
      this.rtlChange(false)
    },
    ...mapActions({
      modeChange: 'Setting/layoutModeAction'
    })
  }
}
</script>
