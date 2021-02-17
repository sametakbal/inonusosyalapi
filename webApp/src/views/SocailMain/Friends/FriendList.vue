<template>
    <div class="row">
      <div v-for="(item,index) in friends" :key="index" class="col-md-6">
        <iq-card body-class="profile-page p-0">
          <template v-slot:body>
            <div class="profile-header-image">
              <div class="cover-container">
                <img :src="item.backgroudimg" alt="profile-bg" class="rounded img-fluid w-100">
              </div>
              <div class="profile-info p-4">
                <div class="user-detail">
                  <div class="d-flex flex-wrap justify-content-between align-items-start">
                    <div class="profile-detail d-flex">
                      <div class="profile-img pr-4">
                        <img :src="item.userimg" alt="profile-img" class="avatar-130 img-fluid" />
                      </div>
                      <div class="user-data-block">
                        <h4 class="">{{item.name}}</h4>
                        <h6>{{item.desgination}}</h6>
                        <p>{{item.text}}</p>
                      </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Following</button>
                  </div>
                </div>
              </div>
            </div>
          </template>
        </iq-card>
      </div>
    </div>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
export default {
  name: 'FriendList',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      friends: [
        {
          name: 'Anna Sthesia',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg2.jpg'),
          userimg: require('../../../assets/images/user/05.jpg')
        },
        {
          name: 'Paul Molive',
          desgination: '@developer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg3.jpg'),
          userimg: require('../../../assets/images/user/06.jpg')
        },
        {
          name: 'Anna Mull',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg4.jpg'),
          userimg: require('../../../assets/images/user/07.jpg')
        },
        {
          name: 'Paige Turner',
          desgination: '@tester',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg5.jpg'),
          userimg: require('../../../assets/images/user/08.jpg')
        },
        {
          name: 'Bob Frapples',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg6.jpg'),
          userimg: require('../../../assets/images/user/09.jpg')
        },
        {
          name: 'Barb Ackue',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg7.jpg'),
          userimg: require('../../../assets/images/user/10.jpg')
        },
        {
          name: 'Greta Life',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg8.jpg'),
          userimg: require('../../../assets/images/user/11.jpg')
        }, {
          name: 'Ira Membrit',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg9.jpg'),
          userimg: require('../../../assets/images/user/12.jpg')
        }, {
          name: 'Pete Sariya',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg1.jpg'),
          userimg: require('../../../assets/images/user/13.jpg')
        },
        {
          name: 'Monty Carlo',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg2.jpg'),
          userimg: require('../../../assets/images/user/14.jpg')
        }, {
          name: 'Ed Itorial',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg3.jpg'),
          userimg: require('../../../assets/images/user/15.jpg')
        },
        {
          name: 'Paul Issy',
          desgination: '@designer',
          text: 'Lorem Ipsum is simply dummy text of the',
          backgroudimg: require('../../../assets/images/page-img/profile-bg4.jpg'),
          userimg: require('../../../assets/images/user/05.jpg')
        }
      ]
    }
  }
}

</script>
