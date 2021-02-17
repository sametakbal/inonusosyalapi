<template>
    <b-row>
      <b-col sm="12">
        <b-row class=" m-0 p-0">
          <b-col lg="8">
            <tab-content id="pills-tabContent-2">
              <tab-content-item :active="true" id="profile-feed" aria-labelled-by="pills-feed-tab">
                <AddSocialPost @addPost="addPost"></AddSocialPost>
                <div  v-for="post in socialPosts" :key="post.id">
                  <social-post :post="post"></social-post>
                </div>
              </tab-content-item>
              <tab-content-item :active="false" id="profile-activity" aria-labelled-by="pills-activity-tab">
                <iq-card>
                  <template v-slot:headerTitle>
                    <h4 class="card-title">Activity timeline</h4>
                  </template>
                  <template v-slot:headerAction>
                    <b-dropdown id="dropdownMenuButton5" right variant="none">
                      <template v-slot:button-content>
                        <span class="text-primary">View All</span>
                      </template>
                      <b-dropdown-item href="#"><i class="ri-eye-fill mr-2"></i>View</b-dropdown-item>
                      <b-dropdown-item href="#"><i class="ri-close-circle-line mr-2"></i>Delete</b-dropdown-item>
                      <b-dropdown-item href="#"><i class="ri-pencil-fill mr-2"></i>Edit</b-dropdown-item>
                      <b-dropdown-item href="#"><i class="ri-printer-fill mr-2"></i>Print</b-dropdown-item>
                      <b-dropdown-item href="#"><i class="ri-file-download-fill mr-2"></i>Download</b-dropdown-item>
                    </b-dropdown>
                  </template>
                  <template v-slot:body>
                    <TimeLine :items="timelineItems" />
                  </template>
                </iq-card>
              </tab-content-item>
              <tab-content-item :active="false" id="profile-friends" aria-labelled-by="pills-friend-tab">
                <iq-card>
                  <template v-slot:headerTitle>
                    <h4 class="card-title">Friends</h4>
                  </template>
                  <template v-slot:body>
                    <ul class="suggestions-lists m-0 p-0">
                      <li v-for="(item,index) in friends" :key="index" class="d-flex mb-4 align-items-center">
                        <div class="user-img img-fluid">
                          <b-img :src="item.image" alt="story-img" rounded="circle" class="avatar-40" />
                        </div>
                        <div class="media-support-info ml-3">
                          <h6>{{ item.name }}</h6>
                          <p class="mb-0">{{ item.role }}</p>
                        </div>
                        <div class="iq-card-header-toolbar d-flex align-items-center">
                          <b-dropdown id="dropdownMenuButton40" right variant="none" menu-class="p-0">
                            <template v-slot:button-content>
                              <i class="ri-more-2-line"></i>
                            </template>
                            <b-dropdown-item href="#"><i class="ri-user-unfollow-line mr-2"></i>Unfollow</b-dropdown-item>
                            <b-dropdown-item href="#"><i class="ri-share-forward-line mr-2"></i>Share</b-dropdown-item>
                            <b-dropdown-item href="#"><i class="ri-file-copy-line mr-2"></i>Copy Link</b-dropdown-item>
                          </b-dropdown>
                        </div>
                      </li>
                    </ul>
                    <b-button href="javascript:void(0);" variant="primary" class="d-block"><i class="ri-add-line"></i> Load More</b-button>
                  </template>
                </iq-card>
              </tab-content-item>
              <tab-content-item :active="false" id="profile-profile" aria-labelled-by="pills-profile-tab">
                <iq-card>
                  <template v-slot:headerTitle>
                    <h4 class="card-title">Profile</h4>
                  </template>
                  <template v-slot:body>
                    <div class="user-detail text-center">
                      <div class="user-profile">
                        <b-img :src="require('../../../assets/images/user/user-11.png')" alt="profile-img" fluid class="avatar-130" />
                      </div>
                      <div class="profile-detail mt-3">
                        <h3 class="d-inline-block">Nik Jone</h3>
                        <p class="d-inline-block pl-3"> - Web designer</p>
                        <p class="mb-0">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 500s</p>
                      </div>
                    </div>
                  </template>
                </iq-card>
                <iq-card>
                  <template v-slot:headerTitle>
                    <h4 class="card-title">About User</h4>
                  </template>
                  <template v-slot:body>
                    <div class="user-bio">
                      <p>Tart I love sugar plum I love oat cake. Sweet roll caramels I love jujubes.Topping cake wafer.</p>
                    </div>
                    <div v-for="(item,index) in userBio" :key="index" class="mt-2">
                      <h6>{{ item.title }}:</h6>
                      <p v-html="item.description"></p>
                    </div>
                  </template>
                </iq-card>
              </tab-content-item>
            </tab-content>
          </b-col>
          <b-col lg="4" >
            <iq-card>
              <template v-slot:headerTitle>
                <h4 class="card-title">Stories</h4>
              </template>
              <template v-slot:body>
                <ul class="media-story m-0 p-0">
                  <li class="d-flex mb-4 align-items-center">
                    <i class="ri-add-line font-size-18"></i>
                    <div class="stories-data ml-3">
                      <h5>Creat Your Story</h5>
                      <p class="mb-0">time to story</p>
                    </div>
                  </li>
                  <li v-for="(item,index) in story" :key="index" class="d-flex align-items-center" :class="item.isActive +' '+ item.class">
                    <b-img :src="item.image" alt="story-img" rounded="circle" fluid />
                    <div class="stories-data ml-3">
                      <h5>{{ item.title }}</h5>
                      <p class="mb-0">{{ item.time }}</p>
                    </div>
                  </li>
                </ul>
                <b-link href="javascript:void(0);" class="btn btn-primary d-block mt-3"><i class="ri-add-line"></i> See All</b-link>
              </template>
            </iq-card>
            <iq-card>
              <template v-slot:headerTitle>
                <h4 class="card-title">Events</h4>
              </template>
              <template v-slot:body>
                <ul class="media-story m-0 p-0">
                  <li class="d-flex mb-4 align-items-center " v-for="(event,index) in event" :key="index">
                    <img :src="event.img" alt="story-img" class="rounded-circle img-fluid">
                    <div class="stories-data ml-3">
                      <h5>{{event.heading}}</h5>
                      <p class="mb-0">{{event.time}}</p>
                    </div>
                  </li>
                </ul>
              </template>
            </iq-card>
            <iq-card>
              <template v-slot:headerTitle>
                <h4 class="card-title">Upcomming Birthday</h4>
              </template>
              <template v-slot:body>
                <ul class="suggestions-lists m-0 p-0">
                  <li v-for="(item,index) in suggestions" :key="index" class="d-flex mb-4 align-items-center">
                    <div class="user-img img-fluid">
                      <b-img :src="item.image" alt="story-img" rounded="circle" class="avatar-40" />
                    </div>
                    <div class="media-support-info ml-3">
                      <h6>{{ item.name }}</h6>
                      <p class="mb-0">{{ item.mutual_friend }}</p>
                    </div>
                  </li>
                </ul>
              </template>
            </iq-card>
            <iq-card>
              <template v-slot:headerTitle>
                <h4 class="card-title">Suggested Pages</h4>
              </template>
              <template v-slot:body>
                <ul class="suggested-page-story m-0 p-0 list-inline">
                  <li class="mb-3" v-for="(post,index) in suggestionEvent" :key="index">
                    <div class="d-flex align-items-center mb-3">
                      <img :src="post.img" alt="story-img" class="rounded-circle img-fluid avatar-50">
                      <div class="stories-data ml-3">
                        <h5>{{post.title}}</h5>
                        <p class="mb-0">{{post.des}}</p>
                      </div>
                    </div>
                    <img :src="post.otherImg" class="img-fluid rounded" alt="Responsive image">
                    <div class="mt-3"><a href="#" class="btn d-block"><i class="ri-thumb-up-line mr-2"></i> Like Page</a></div>
                  </li>
                </ul>
              </template>
            </iq-card>
          </b-col>
        </b-row>
      </b-col>
       <div class="col-sm-12 text-center">
          <img src="../../../assets/images/page-img/page-load-loader.gif" alt="loader" style="height: 100px;">
        </div>
    </b-row>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
import SocialPost from './Components/SocialPost'
import { Posts } from '../../../FackApi/api/SocialPost'
import AddSocialPost from './Components/AddSocialPost'
import IqCard from '../../../components/socialvue/cards/iq-card'

export default {
  name: 'SocialApp',
  components: { IqCard, AddSocialPost, SocialPost },
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      suggestionEvent: [
        {
          img: require('../../../assets/images/page-img/42.png'),
          title: 'Iqonic Studio',
          des: 'Lorem Ipsum',
          otherImg: require('../../../assets/images/small/img-1.jpg')
        },
        {
          img: require('../../../assets/images/page-img/43.png'),
          title: 'Cakes & Bakes ',
          des: 'Lorem Ipsum',
          otherImg: require('../../../assets/images/small/img-2.jpg')
        }
      ],
      event: [
        {
          img: require('../../../assets/images/page-img/s4.jpg'),
          heading: 'Web Workshop',
          time: '1 hour ago'
        },
        {
          img: require('../../../assets/images/page-img/s5.jpg'),
          heading: 'Fun Events and Festivals',
          time: '4 hour ago'
        }
      ],
      user: {
        background: require('../../../assets/images/page-img/profile-bg.jpg'),
        profile: require('../../../assets/images/user/user-11.png'),
        name: 'Nik Jone',
        role: ' - Web designer',
        about: 'Lorem ipsum dolor sit amet, contur adipiscing elit.',
        email: 'nikjone@demoo.com',
        phone: '001 2351 256 12',
        location: 'USA',
        careated_date: '07 Jan 2020'
      },
      socialPosts: Posts,
      galary: [
        { image: require('../../../assets/images/page-img/g1.jpg'), href: 'javascript:void(0);' },
        { image: require('../../../assets/images/page-img/g2.jpg'), href: 'javascript:void(0);' },
        { image: require('../../../assets/images/page-img/g3.jpg'), href: 'javascript:void(0);' },
        { image: require('../../../assets/images/page-img/g4.jpg'), href: 'javascript:void(0);' },
        { image: require('../../../assets/images/page-img/g5.jpg'), href: 'javascript:void(0);' },
        { image: require('../../../assets/images/page-img/g6.jpg'), href: 'javascript:void(0);' },
        { image: require('../../../assets/images/page-img/g7.jpg'), href: 'javascript:void(0);' },
        { image: require('../../../assets/images/page-img/g8.jpg'), href: 'javascript:void(0);' },
        { image: require('../../../assets/images/page-img/g9.jpg'), href: 'javascript:void(0);' }
      ],
      action: [
        {
          icon: 'ri-eye-fill mr-2',
          title: 'View'
        },
        {
          icon: 'ri-delete-bin-6-fill mr-2',
          title: 'Delete'
        },
        {
          icon: 'ri-pencil-fill mr-2',
          title: 'Edit'
        },
        {
          icon: 'ri-printer-fill mr-2',
          title: 'Print'
        },
        {
          icon: 'ri-file-download-fill mr-2',
          title: 'Download'
        }
      ],
      timelineItems: [
        {
          color: 'primary',
          title: 'Client Login',
          right: '24 November 2019',
          description: 'Bonbon macaroon jelly beans gummi bears jelly lollipop apple',
          child: {
            type: 'img',
            items: [
            ]
          }
        },
        {
          color: 'success',
          title: 'Scheduled Maintenance',
          right: '23 November 2019',
          description: 'Bonbon macaroon jelly beans gummi bears jelly lollipop apple',
          child: {
            type: 'img',
            items: [
            ]
          }
        },
        {
          color: 'danger',
          title: 'Dev Meetup',
          right: '20 November 2019',
          description: 'Bonbon macaroon jelly <b-link href="">beans gummi</b-link> bears jelly lollipop apple',
          child: {
            type: 'img',
            items: [
              require('../../../assets/images/user/user-05.jpg'),
              require('../../../assets/images/user/user-06.jpg'),
              require('../../../assets/images/user/user-07.jpg'),
              require('../../../assets/images/user/user-08.jpg'),
              require('../../../assets/images/user/user-09.jpg'),
              require('../../../assets/images/user/user10.jpg')
            ]
          }
        },
        {
          color: 'primary',
          title: 'Client Call',
          right: '19 November 2019',
          description: 'Bonbon macaroon jelly beans gummi bears jelly lollipop apple',
          child: {
            type: 'img',
            items: [
            ]
          }
        },
        {
          color: 'warning',
          title: 'Mega Event',
          right: '15 November 2019',
          description: 'Bonbon macaroon jelly beans gummi bears jelly lollipop apple',
          child: {
            type: 'img',
            items: [
            ]
          }
        }
      ],
      friends: [
        { name: 'Paul Molive', role: 'Web Designer', image: require('../../../assets/images/user/user-01.jpg') },
        { name: 'Paul Molive', role: 'trainee', image: require('../../../assets/images/user/user-01.jpg') }
      ],
      userBio: [
        { title: 'Joined', description: 'November 15, 2012' },
        { title: 'Lives', description: 'United States of America' },
        { title: 'Email', description: '<a href="mailto:nikjone@gmail.com"> nikjone@gmail.com</a>' },
        { title: 'Url', description: '<a href="https://getbootstrap.com/docs/4.0/getting-started/introduction/" target="_blank"> www.bootstrap.com </a>' },
        { title: 'Contact', description: '<a href="tel:001 4544 565 456">(001) 4544 565 456</a>' }
      ],
      story: [
        { title: 'Web Design', time: '1 hour ago', image: require('../../../assets/images/page-img/s1.jpg'), class: 'mb-4', isActive: 'active' },
        { title: 'App Design', time: '4 hour ago', image: require('../../../assets/images/page-img/s2.jpg'), class: 'mb-4', isActive: '' },
        { title: 'Abstract Design', time: '9 hour ago', image: require('../../../assets/images/page-img/s3.jpg'), class: '', isActive: '' }
      ],
      suggestions: [
        { name: 'Paul Molive', mutual_friend: 'Today', image: require('../../../assets/images/user/user-01.jpg') },
        { name: 'Paul Molive', mutual_friend: 'Tomorrow', image: require('../../../assets/images/user/user-01.jpg') }
      ],
      news: [
        { description: 'there is a meetup in your city on friday at 19:00.<a href="#">see details</a>' },
        { description: '20% off coupon on selected items at pharmaprix' }
      ],
      twitterFeed: [
        {
          image: require('../../../assets/images/page-img/42.jpg'),
          name: 'UI/Ux Designer',
          description: 'Creativity Design'
        },
        {
          image: require('../../../assets/images/page-img/43.jpg'),
          name: 'Marketing',
          description: 'Accounting'
        },
        {
          image: require('../../../assets/images/page-img/44.jpg'),
          name: 'Web Developer',
          description: 'uniq Concept'
        },
        {
          image: require('../../../assets/images/page-img/45.jpg'),
          name: 'Latest News',
          description: 'Line information'
        }
      ],
      recentPages: [
        {
          image: require('../../../assets/images/page-img/46.jpg'),
          name: 'Food town'
        },
        {
          image: require('../../../assets/images/page-img/47.jpg'),
          name: 'Touro Univercity'
        },
        {
          image: require('../../../assets/images/page-img/48.jpg'),
          name: 'Moviehouse & Eatery'
        },
        {
          image: require('../../../assets/images/page-img/49.jpg'),
          name: 'Coffee + Crisp'
        }
      ]
    }
  },
  methods: {
    addPost (post) {
      this.socialPosts.unshift(post)
    }
  }
}
</script>
