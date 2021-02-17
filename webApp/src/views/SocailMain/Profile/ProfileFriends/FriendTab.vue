<template>
  <div class="friend-list-tab mt-2">
  <tab-nav :pills="true" id="tab" class="nav nav-pills d-flex align-items-center justify-content-left friend-list-items p-0 mb-2" >
    <tab-nav-items liClass=" " :active="true" id="pills-all-friends" href="#all-friends" ariaControls="pills-all-friends" role="tab" :ariaSelected="true" title="All Friends" />
    <tab-nav-items liClass=" " :active="false" id="pills-recently-add"  href="#recently-add" ariaControls="pills-recently-add" role="tab" :ariaSelected="false" title="Recently Added" />
    <tab-nav-items liClass=" " :active="false" id="pills-closefriends"  href="#closefriends" ariaControls="pills-closefriends" role="tab" :ariaSelected="false" title="Close friends" />
    <tab-nav-items liClass=" " :active="false" id="pills-home" href="#home" ariaControls="pills-home" role="tab" :ariaSelected="false" title="Home/Town" />
    <tab-nav-items liClass=" " :active="false" id="pills-following-add"  href="#recently-add" ariaControls="pills-recently-add" role="tab" :ariaSelected="false" title="Following" />
  </tab-nav>
  <div class="tab-content">
    <tab-content-item :active="true" id="all-friends" aria-labelled-by="pills-all-friends">
      <div class="iq-card-body p-0">
        <div class="row">
          <div class="col-md-6 col-lg-6 mb-3" v-for="(fried,index1) in frieds" :key="index1">
            <div class="iq-friendlist-block">
              <div class="d-flex align-items-center justify-content-between">
                <div class="d-flex align-items-center">
                  <a href="#">
                    <img :src="fried.img" alt="profile-img" class="img-fluid">
                  </a>
                  <div class="friend-info ml-3">
                    <h5>{{fried.name}}</h5>
                    <p class="mb-0">{{fried.friend}}</p>
                  </div>
                </div>
                <div class="iq-card-header-toolbar d-flex align-items-center">
                  <div class="dropdown">
                   <span class="dropdown-toggle btn btn-secondary mr-2" id="dropdownMenuButton01" data-toggle="dropdown" aria-expanded="true" role="button">
                   <i class="ri-check-line mr-1 text-white font-size-16"></i> Friend
                   </span>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton01">
                      <a class="dropdown-item" href="#">Get Notification</a>
                      <a class="dropdown-item" href="#">Close Friend</a>
                      <a class="dropdown-item" href="#">Unfollow</a>
                      <a class="dropdown-item" href="#">Unfriend</a>
                      <a class="dropdown-item" href="#">Block</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </tab-content-item>
    <tab-content-item :active="true" id="recently-add" aria-labelled-by="pills-recently-add">
      <div class="iq-card-body p-0">
        <div class="row">
          <div class="col-md-6 col-lg-6 mb-3" v-for="(item,index) in recentlyAdded" :key="index">
            <div class="iq-friendlist-block">
              <div class="d-flex align-items-center justify-content-between">
                <div class="d-flex align-items-center">
                  <a href="#">
                    <img :src="item.img" alt="profile-img" class="img-fluid">
                  </a>
                  <div class="friend-info ml-3">
                    <h5>{{item.name}}</h5>
                    <p class="mb-0">{{item.friend}}</p>
                  </div>
                </div>
                <div class="iq-card-header-toolbar d-flex align-items-center">
                  <div class="dropdown">
                     <span class="dropdown-toggle btn btn-secondary mr-2" id="dropdownMenuButton31" data-toggle="dropdown" aria-expanded="true" role="button">
                     <i class="ri-check-line mr-1 text-white font-size-16"></i> Friend
                     </span>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton31">
                      <a class="dropdown-item" href="#">Get Notification</a>
                      <a class="dropdown-item" href="#">Close Friend</a>
                      <a class="dropdown-item" href="#">Unfollow</a>
                      <a class="dropdown-item" href="#">Unfriend</a>
                      <a class="dropdown-item" href="#">Block</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </tab-content-item>
    <tab-content-item :active="true" id="closefriends" aria-labelled-by="pills-closefriends">
      <div class="iq-card-body p-0">
        <div class="row">
          <div class="col-md-6 col-lg-6 mb-3" v-for="(closefriend, index) in closeFriend" :key="index">
            <div class="iq-friendlist-block">
              <div class="d-flex align-items-center justify-content-between">
                <div class="d-flex align-items-center">
                  <a href="#">
                    <img :src="closefriend.img" alt="profile-img" class="img-fluid">
                  </a>
                  <div class="friend-info ml-3">
                    <h5>{{closefriend.name}}</h5>
                    <p class="mb-0">{{closefriend.friend}}</p>
                  </div>
                </div>
                <div class="iq-card-header-toolbar d-flex align-items-center">
                  <div class="dropdown">
                   <span class="dropdown-toggle btn btn-secondary mr-2" id="dropdownMenuButton39" data-toggle="dropdown" aria-expanded="true" role="button">
                   <i class="ri-check-line mr-1 text-white font-size-16"></i> Friend
                   </span>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton39">
                      <a class="dropdown-item" href="#">Get Notification</a>
                      <a class="dropdown-item" href="#">Close Friend</a>
                      <a class="dropdown-item" href="#">Unfollow</a>
                      <a class="dropdown-item" href="#">Unfriend</a>
                      <a class="dropdown-item" href="#">Block</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </tab-content-item>
    <tab-content-item :active="true" id="home" aria-labelled-by="pills-home">
      <div class="iq-card-body p-0">
        <div class="row">
          <div class="col-md-6 col-lg-6 mb-3" v-for="(home,index) in homeTown" :key="index">
            <div class="iq-friendlist-block">
              <div class="d-flex align-items-center justify-content-between">
                <div class="d-flex align-items-center">
                  <a href="#">
                    <img :src="home.img" alt="profile-img" class="img-fluid">
                  </a>
                  <div class="friend-info ml-3">
                    <h5>{{home.name}}</h5>
                    <p class="mb-0">{{home.friend}}</p>
                  </div>
                </div>
                <div class="iq-card-header-toolbar d-flex align-items-center">
                  <div class="dropdown">
                     <span class="dropdown-toggle btn btn-secondary mr-2" id="dropdownMenuButton49" data-toggle="dropdown" aria-expanded="true" role="button">
                     <i class="ri-check-line mr-1 text-white font-size-16"></i> Friend
                     </span>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton49">
                      <a class="dropdown-item" href="#">Get Notification</a>
                      <a class="dropdown-item" href="#">Close Friend</a>
                      <a class="dropdown-item" href="#">Unfollow</a>
                      <a class="dropdown-item" href="#">Unfriend</a>
                      <a class="dropdown-item" href="#">Block</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    </tab-content-item>
  </div>
  </div>

</template>
<script>
import { socialvue } from '../../../../config/pluginInit'
export default {
  name: 'FriendTab',
  mounted () {
    socialvue.index()
  },
  components: {
  },
  data () {
    return {
      frieds: [
        {
          img: require('../../../../assets/images/user/05.jpg'),
          name: 'Jaques Amole',
          friend: '40  friends'
        },
        {
          img: require('../../../../assets/images/user/06.jpg'),
          name: 'Lucy Tania',
          friend: '12  friends'
        },
        {
          img: require('../../../../assets/images/user/07.jpg'),
          name: 'Val Adictorian',
          friend: '0  friends'
        },
        {
          img: require('../../../../assets/images/user/08.jpg'),
          name: 'Manny Petty',
          friend: '3  friends'
        },
        {
          img: require('../../../../assets/images/user/09.jpg'),
          name: 'Marsha Mello',
          friend: '15  friends'
        },
        {
          img: require('../../../../assets/images/user/10.jpg'),
          name: 'Caire Innet',
          friend: '8  friends'
        },
        {
          img: require('../../../../assets/images/user/05.jpg'),
          name: 'Paul Misunday',
          friend: '6  friends'
        },
        {
          img: require('../../../../assets/images/user/13.jpg'),
          name: 'Reanne Carnation',
          friend: '12  friends'
        }
      ],
      recentlyAdded: [
        {
          img: require('../../../../assets/images/user/05.jpg'),
          name: 'Jaques Amole',
          friend: '40  friends'
        },
        {
          img: require('../../../../assets/images/user/06.jpg'),
          name: 'Lucy Tania',
          friend: '12  friends'
        },
        {
          img: require('../../../../assets/images/user/07.jpg'),
          name: 'Val Adictorian',
          friend: '0  friends'
        },
        {
          img: require('../../../../assets/images/user/08.jpg'),
          name: 'Manny Petty',
          friend: '3  friends'
        },
        {
          img: require('../../../../assets/images/user/09.jpg'),
          name: 'Marsha Mello',
          friend: '15  friends'
        },
        {
          img: require('../../../../assets/images/user/10.jpg'),
          name: 'Caire Innet',
          friend: '8  friends'
        }
      ],
      closeFriend: [
        {
          img: require('../../../../assets/images/user/07.jpg'),
          name: 'Val Adictorian',
          friend: '0  friends'
        },
        {
          img: require('../../../../assets/images/user/08.jpg'),
          name: 'Manny Petty',
          friend: '3  friends'
        },
        {
          img: require('../../../../assets/images/user/09.jpg'),
          name: 'Marsha Mello',
          friend: '15  friends'
        },
        {
          img: require('../../../../assets/images/user/10.jpg'),
          name: 'Caire Innet',
          friend: '8  friends'
        },
        {
          img: require('../../../../assets/images/user/05.jpg'),
          name: 'Paul Misunday',
          friend: '6  friends'
        },
        {
          img: require('../../../../assets/images/user/13.jpg'),
          name: 'Reanne Carnation',
          friend: '12  friends'
        }
      ],
      homeTown: [
        {
          img: require('../../../../assets/images/user/08.jpg'),
          name: 'Manny Petty',
          friend: '3  friends'
        },
        {
          img: require('../../../../assets/images/user/09.jpg'),
          name: 'Marsha Mello',
          friend: '15  friends'
        },
        {
          img: require('../../../../assets/images/user/10.jpg'),
          name: 'Caire Innet',
          friend: '8  friends'
        },
        {
          img: require('../../../../assets/images/user/05.jpg'),
          name: 'Paul Misunday',
          friend: '6  friends'
        }
      ],
      follwing: [
        {
          img: require('../../../../assets/images/user/09.jpg'),
          name: 'Marsha Mello',
          friend: '15  friends'
        },
        {
          img: require('../../../../assets/images/user/10.jpg'),
          name: 'Caire Innet',
          friend: '8  friends'
        },
        {
          img: require('../../../../assets/images/user/05.jpg'),
          name: 'Paul Misunday',
          friend: '6  friends'
        },
        {
          img: require('../../../../assets/images/user/13.jpg'),
          name: 'Reanne Carnation',
          friend: '12  friends'
        }
      ]
    }
  }
}
</script>
