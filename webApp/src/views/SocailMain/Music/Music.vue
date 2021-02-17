<template>
<b-row>
  <b-col md="4">
    <b-card class="iq-card iq-card-block iq-card-stretch iq-card-height">
        <div class="iq-card-header d-flex justify-content-between">
            <div class="iq-header-title">
              <h4 class="card-title">Play Lists</h4>
            </div>
        </div>
        <div class="iq-card-body">
            <ul class="music-lists m-0 p-0">
              <li class="d-flex mb-4 align-items-center" v-for="(music,index) in musicData" :key="index">
                  <div class="user-img img-fluid"><img :src="music.img" alt="story-img" class="rounded-circle avatar-40"></div>
                  <div class="media-support-info ml-3">
                    <h6>{{music.heading}}</h6>
                  </div>
                  <div class="music-time">{{music.time}}</div>
              </li>
            </ul>
        </div>
    </b-card>
  </b-col>
  <b-col md="8">
    <div class="iq-card iq-card-block iq-card-stretch iq-card-height">
      <div class="iq-card-body p-0  ">
        <a href="#"><img src="../../../assets/images/page-img/48.jpg" alt="story-img" class="img-fluid rounded"></a>
      </div>
    </div>
  </b-col>
  <b-col sm="12">
    <div class="iq-card iq-card-block iq-card-stretch iq-card-height">
      <div class="iq-card-header d-flex justify-content-between">
        <div class="iq-header-title">
          <h4 class="card-title">New Music</h4>
        </div>
        <div class="iq-card-header-toolbar d-flex align-items-center">
          <a href="#">View All</a>
        </div>
      </div>
      <div class="iq-card-body">
        <Slick id="post-slider" class="d-flex list-inline m-0 p-0">
          <li class="text-center col-md-12" v-for="(newmusic,index) in newMusic" :key="index">
            <div class="music-thumbnail position-relative mb-3">
              <a href="#"><img :src="newmusic.img" alt="music-thumb" class="img-fluid w-100"></a>
              <div class="play-btn">
                <a href="#"><i class="ri-play-fill text-white"></i></a>
              </div>
            </div>
            <h6>{{newmusic.name}}</h6>
            <p class="mb-0">Best Advice</p>
          </li>
        </Slick>
      </div>
    </div>
  </b-col>
  <b-col sm="12">
    <div class="iq-card iq-card-block iq-card-stretch iq-card-height">
      <div class="iq-card-header d-flex justify-content-between">
        <div class="iq-header-title">
          <h4 class="card-title">Recent Added</h4>
        </div>
        <div class="iq-card-header-toolbar d-flex align-items-center">
          <a href="#">View All</a>
        </div>
      </div>
      <div class="iq-card-body">
        <Slick id="recent-music" class="d-flex list-inline m-0 p-0">
          <li class="text-center col-md-12" v-for="(recent,index) in recentAdded" :key="index">
            <div class="music-thumbnail position-relative mb-3">
              <a href="#"><img :src="recent.img" alt="music-thumb" class="img-fluid w-100"></a>
              <div class="play-btn">
                <a href="#"><i class="ri-play-fill text-white"></i></a>
              </div>
            </div>
            <h6>{{recent.heading}}</h6>
            <p class="mb-0">Best Advice</p>
          </li>
        </Slick>
      </div>
    </div>
  </b-col>
  <b-col sm="12">
    <div class="iq-card iq-card-block iq-card-stretch iq-card-height">
      <div class="iq-card-header d-flex justify-content-between">
        <div class="iq-header-title">
          <h4 class="card-title">Top Music</h4>
        </div>
        <div class="iq-card-header-toolbar d-flex align-items-center">
          <a href="#">View All</a>
        </div>
      </div>
      <div class="iq-card-body">
        <Slick id="recent-music" class="d-flex list-inline m-0 p-0">
          <li class="text-center col-md-12" v-for="(music,index) in topMusic" :key="index">
            <div class="music-thumbnail position-relative mb-3">
              <a href="#"><img :src="music.img" alt="music-thumb" class="img-fluid w-100"></a>
              <div class="play-btn">
                <a href="#"><i class="ri-play-fill text-white"></i></a>
              </div>
            </div>
            <h6>{{music.heading}}</h6>
            <p class="mb-0">Best Advice</p>
          </li>
        </Slick>
      </div>
    </div>
  </b-col>
</b-row>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
export default {
  name: 'Music',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      musicData: [
        {
          img: require('../../../assets/images/page-img/l1.jpg'),
          heading: 'Ember',
          time: '3:00'
        },
        {
          img: require('../../../assets/images/page-img/l2.jpg'),
          heading: 'Light Out(Bonus Track',
          time: '5:00'
        },
        {
          img: require('../../../assets/images/page-img/l3.jpg'),
          heading: 'Darkness Overture',
          time: '2:30'
        },
        {
          img: require('../../../assets/images/page-img/l4.jpg'),
          heading: 'Dritin',
          time: '4:20'
        },
        {
          img: require('../../../assets/images/page-img/l5.jpg'),
          heading: 'Bones',
          time: '2:00'
        },
        {
          img: require('../../../assets/images/page-img/l6.jpg'),
          heading: 'Hozier',
          time: '1:45'
        }
      ],
      newMusic: [
        {
          img: require('../../../assets/images/page-img/n1.jpg'),
          name: 'Sean Paul'
        },
        {
          img: require('../../../assets/images/page-img/n2.jpg'),
          name: 'Fetty Wap'
        },
        {
          img: require('../../../assets/images/page-img/n3.jpg'),
          name: 'Brittany Howard'
        },
        {
          img: require('../../../assets/images/page-img/n4.jpg'),
          name: 'Elton John'
        },
        {
          img: require('../../../assets/images/page-img/n5.jpg'),
          name: 'Sean Paul'
        },
        {
          img: require('../../../assets/images/page-img/n6.jpg'),
          name: 'Tierra Whack'
        },
        {
          img: require('../../../assets/images/page-img/n7.jpg'),
          name: 'Trippie Redd'
        },
        {
          img: require('../../../assets/images/page-img/n8.jpg'),
          name: 'Quincy Jones'
        }
      ],
      recentAdded: [
        {
          img: require('../../../assets/images/page-img/n8.jpg'),
          heading: 'Lizzo'
        },
        {
          img: require('../../../assets/images/page-img/r8.jpg'),
          heading: 'Kathleen Hanna'
        },
        {
          img: require('../../../assets/images/page-img/n7.jpg'),
          heading: 'Sheryl Crow'
        },
        {
          img: require('../../../assets/images/page-img/r1.jpg'),
          heading: 'Karen O'
        },
        {
          img: require('../../../assets/images/page-img/n1.jpg'),
          heading: 'Cyndi Lauper'
        },
        {
          img: require('../../../assets/images/page-img/r2.jpg'),
          heading: 'Rick Ross'
        },
        {
          img: require('../../../assets/images/page-img/r7.jpg'),
          heading: 'Kamasi Washington'
        },
        {
          img: require('../../../assets/images/page-img/n2.jpg'),
          heading: 'Christina Aguilera'
        }
      ],
      topMusic: [
        {
          img: require('../../../assets/images/page-img/r1.jpg'),
          heading: 'Mary J. Blige'
        },
        {
          img: require('../../../assets/images/page-img/r2.jpg'),
          heading: 'Ne-Yo'
        },
        {
          img: require('../../../assets/images/page-img/r3.jpg'),
          heading: 'Annie Flook'
        },
        {
          img: require('../../../assets/images/page-img/r4.jpg'),
          heading: 'Karen O'
        },
        {
          img: require('../../../assets/images/page-img/r5.jpg'),
          heading: 'Alex Gvojic'
        },
        {
          img: require('../../../assets/images/page-img/r6.jpg'),
          heading: 'Mindy Monk'
        },
        {
          img: require('../../../assets/images/page-img/r7.jpg'),
          heading: 'Coffey Rock'
        },
        {
          img: require('../../../assets/images/page-img/r8.jpg'),
          heading: 'Sam Smith'
        }
      ]
    }
  }
}
</script>
