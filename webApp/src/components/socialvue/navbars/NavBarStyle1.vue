<template>
  <!-- TOP Nav Bar -->
    <div class="iq-top-navbar">
      <div class="iq-navbar-custom">
        <nav class="navbar navbar-expand-lg navbar-light p-0">
            <div class="iq-navbar-logo d-flex justify-content-between">
              <a href="#">
                <img :src="logo" class="img-fluid" alt="logo">
                <span>SocialV</span>
              </a>
              <div class="iq-menu-bt align-self-center">
                <div class="wrapper-menu" @click="miniSidebar">
                    <div class="main-circle"><i class="ri-menu-line"></i></div>
                </div>
              </div>
            </div>
            <div class="iq-search-bar">
              <form action="#" class="searchbox">
                  <input type="text" class="text search-input" placeholder="Type here to search...">
                  <a class="search-link" href="#"><i class="ri-search-line"></i></a>
              </form>
            </div>
            <b-navbar-toggle target="nav-collapse" class="mr-2">
              <i class="ri-menu-3-line"></i>
            </b-navbar-toggle>
            <b-collapse id="nav-collapse" is-nav>
              <ul class="navbar-nav ml-auto navbar-list">
                  <li>
                    <a href="#" class="iq-waves-effect d-flex align-items-center">
                        <img src="../../../assets/images/user/1.jpg" class="img-fluid rounded-circle mr-3" alt="user">
                        <div class="caption">
                          <h6 class="mb-0 line-height">Bni Cyst</h6>
                        </div>
                    </a>
                  </li>
                  <li>
                    <a href="#" class="iq-waves-effect d-flex align-items-center">
                    <i class="ri-home-line"></i>
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="search-toggle iq-waves-effect" href="#"><i class="ri-group-line"></i></a>
                    <div class="iq-sub-dropdown iq-sub-dropdown-large">
                        <div class="iq-card shadow-none m-0">
                          <div class="iq-card-body p-0 ">
                              <div class="bg-primary p-3">
                                <h5 class="mb-0 text-white">Friend Request<small class="badge  badge-light float-right pt-1">4</small></h5>
                              </div>
                              <div class="iq-friend-request" v-for="(item,index) in userFriendRequest" :key="index">
                                <div class="iq-sub-card iq-sub-card-big d-flex align-items-center justify-content-between" >
                                    <div class="d-flex align-items-center">
                                      <div class="">
                                          <img class="avatar-40 rounded" :src="item.img" alt="">
                                      </div>
                                      <div class="media-body ml-3">
                                          <h6 class="mb-0 ">{{item.name}}</h6>
                                          <p class="mb-0">{{item.friend}}</p>
                                      </div>
                                    </div>
                                    <div class="d-flex align-items-center">
                                      <a href="#" class="mr-3 btn btn-primary rounded">Confirm</a>
                                      <a href="#" class="mr-3 btn btn-secondary rounded">Delete Request</a>
                                    </div>
                                </div>
                              </div>
                              <div class="text-center">
                                <a href="#" class="mr-3 btn text-primary">View More Request</a>
                              </div>
                          </div>
                        </div>
                    </div>
                  </li>
                  <li class="nav-item">
                    <a href="#" class="search-toggle iq-waves-effect">
                      <lottie :option="require('../../../assets/images/small/lottie-bell')" id="lottie-beil" />
                        <span class="bg-danger dots"></span>
                    </a>
                    <div class="iq-sub-dropdown">
                        <div class="iq-card shadow-none m-0">
                          <div class="iq-card-body p-0 ">
                              <div class="bg-primary p-3">
                                <h5 class="mb-0 text-white">All Notifications<small class="badge  badge-light float-right pt-1">4</small></h5>
                              </div>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/01.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Emma Watson Bni</h6>
                                      <small class="float-right font-size-12">Just Now</small>
                                      <p class="mb-0">95 MB</p>
                                    </div>
                                </div>
                              </a>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/02.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">New customer is join</h6>
                                      <small class="float-right font-size-12">5 days ago</small>
                                      <p class="mb-0">Cyst Bni</p>
                                    </div>
                                </div>
                              </a>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/03.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Two customer is left</h6>
                                      <small class="float-right font-size-12">2 days ago</small>
                                      <p class="mb-0">Cyst Bni</p>
                                    </div>
                                </div>
                              </a>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/04.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">New Mail from Fenny</h6>
                                      <small class="float-right font-size-12">3 days ago</small>
                                      <p class="mb-0">Cyst Bni</p>
                                    </div>
                                </div>
                                </div>
                              </a>
                          </div>
                        </div>
                    </div>
                  </li>
                  <li class="nav-item dropdown">
                    <a href="#" class="search-toggle iq-waves-effect">
                      <lottie :option="require('../../../assets/images/small/lottie-mail')" id="lottie-mail" />
                        <span class="bg-primary count-mail"></span>
                    </a>
                    <div class="iq-sub-dropdown">
                        <div class="iq-card shadow-none m-0">
                          <div class="iq-card-body p-0 ">
                              <div class="bg-primary p-3">
                                <h5 class="mb-0 text-white">All Messages<small class="badge  badge-light float-right pt-1">5</small></h5>
                              </div>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/01.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Bni Emma Watson</h6>
                                      <small class="float-left font-size-12">13 Jun</small>
                                    </div>
                                </div>
                              </a>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/02.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Lorem Ipsum Watson</h6>
                                      <small class="float-left font-size-12">20 Apr</small>
                                    </div>
                                </div>
                              </a>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/03.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Why do we use it?</h6>
                                      <small class="float-left font-size-12">30 Jun</small>
                                    </div>
                                </div>
                              </a>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/04.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Variations Passages</h6>
                                      <small class="float-left font-size-12">12 Sep</small>
                                    </div>
                                </div>
                              </a>
                              <a href="#" class="iq-sub-card" >
                                <div class="media align-items-center">
                                    <div class="">
                                      <img class="avatar-40 rounded" src="../../../assets/images/user/05.jpg" alt="">
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Lorem Ipsum generators</h6>
                                      <small class="float-left font-size-12">5 Dec</small>
                                    </div>
                                </div>
                              </a>
                          </div>
                        </div>
                    </div>
                  </li>
              </ul>
              <ul class="navbar-list">
                  <li>
                    <a href="#" class="search-toggle iq-waves-effect d-flex align-items-center">
                    <i class="ri-arrow-down-s-fill"></i>
                    </a>
                    <div class="iq-sub-dropdown iq-user-dropdown">
                        <div class="iq-card shadow-none m-0">
                          <div class="iq-card-body p-0 ">
                              <div class="bg-primary p-3 line-height">
                                <h5 class="mb-0 text-white line-height">Hello Bni Cyst</h5>
                                <span class="text-white font-size-12">Available</span>
                              </div>
                              <router-link to="/" class="iq-sub-card iq-bg-primary-hover">
                                <div class="media align-items-center">
                                    <div class="rounded iq-card-icon iq-bg-primary">
                                      <i class="ri-file-user-line"></i>
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">My Profile</h6>
                                      <p class="mb-0 font-size-12">View personal profile details.</p>
                                    </div>
                                </div>
                              </router-link>
                              <router-link to="/user/profile-edit"  class="iq-sub-card iq-bg-warning-hover">
                                <div class="media align-items-center">
                                    <div class="rounded iq-card-icon iq-bg-warning">
                                      <i class="ri-profile-line"></i>
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Edit Profile</h6>
                                      <p class="mb-0 font-size-12">Modify your personal details.</p>
                                    </div>
                                </div>
                              </router-link>
                              <router-link to="/account-setting" class="iq-sub-card iq-bg-info-hover">
                                <div class="media align-items-center">
                                    <div class="rounded iq-card-icon iq-bg-info">
                                      <i class="ri-account-box-line"></i>
                                    </div>
                                    <div class="media-body ml-3">
                                      <h6 class="mb-0 ">Account settings</h6>
                                      <p class="mb-0 font-size-12">Manage your account parameters.</p>
                                    </div>
                                </div>
                              </router-link>
                              <div class="d-inline-block w-100 text-center p-3">
                                <a class="bg-primary iq-sign-btn" href="#" role="button">Sign out<i class="ri-login-box-line ml-2"></i></a>
                              </div>
                          </div>
                        </div>
                    </div>
                  </li>
              </ul>
            </b-collapse>
        </nav>
      </div>
    </div>
  <!-- TOP Nav Bar END -->
</template>
<script>
import SideBarItems from '../../../FackApi/json/SideBar'
import { mapGetters } from 'vuex'
import Lottie from '../../../components/socialvue/lottie/Lottie'
export default {
  name: 'NavBarStyle1',
  props: {
    homeURL: { type: Object, default: () => ({ name: 'layout1.dashboard' }) },
    title: { type: String, default: 'Dashboard' },
    logo: { type: String, default: require('../../../assets/images/logo.png') },
    horizontal: { type: Boolean, default: false },
    items: { type: Array }
  },
  mounted () {
    document.addEventListener('click', this.closeSearch, true)
  },
  components: {
    Lottie
  },
  computed: {
    ...mapGetters({
      bookmark: 'Setting/bookmarkState'
    })
  },
  data () {
    return {
      sidebar: SideBarItems,
      globalSearch: '',
      showSearch: false,
      showMenu: false,
      userFriendRequest: [
        {
          img: require('../../../assets/images/user/05.jpg'),
          name: 'Jaques Amole',
          friend: '40  friends'
        },
        {
          img: require('../../../assets/images/user/06.jpg'),
          name: 'Lucy Tania',
          friend: '12  friends'
        },
        {
          img: require('../../../assets/images/user/07.jpg'),
          name: 'Val Adictorian',
          friend: '0  friends'
        },
        {
          img: require('../../../assets/images/user/08.jpg'),
          name: 'Manny Petty',
          friend: '3  friends'
        }

      ]
    }
  },
  methods: {
    miniSidebar () {
      this.$emit('toggle')
    },
    openSearch () {
      this.showSearch = true
      this.showMenu = 'iq-show'
      this.globalSearch = ''
    },
    closeSearch (event) {
      let classList = event.target.classList
      if (!classList.contains('searchbox') && !classList.contains('search-input')) {
        this.removeClass()
      }
    },
    removeClass () {
      this.showSearch = false
      this.showMenu = ''
      this.globalSearch = ''
    }
  }
}
</script>
