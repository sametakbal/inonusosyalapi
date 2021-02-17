  <template>
  <b-row>
    <b-col sm="12">
      <div class="iq-card-header d-flex justify-content-between">
          <div class="iq-header-title">
             <h4 class="card-title mb-2">Notification</h4>
          </div>
      </div>
    </b-col>
    <b-col sm="12">
      <div class="iq-card" v-for="(data,index) in notificationData" :key="index">
        <div class="iq-card-body">
          <ul class="notification-list m-0 p-0">
            <li class="d-flex align-items-center" >
              <div class="user-img img-fluid"><img :src="data.img" alt="story-img" class="rounded-circle avatar-40"></div>
              <div class="media-support-info ml-3">
                <h6>{{data.heading}}</h6>
                <p class="mb-0">{{data.time}}</p>
              </div>
              <div class="d-flex align-items-center">
                <a href="#" class="mr-3 iq-notify iq-bg-primary rounded">
                  <i :class="data.icon"></i></a>
                <div class="iq-card-header-toolbar d-flex align-items-center">
                     <b-dropdown id="dropdownMenuButton40" right variant="none" menu-class="p-0">
                      <template v-slot:button-content>
                        <b-link href="#" class="dropdown-toggle text-primary"><i class="ml-3 ri-more-2-line"></i></b-link>
                      </template>
                      <b-dropdown-item href="#"><i class="ri-eye-fill mr-2"></i>View</b-dropdown-item>
                      <b-dropdown-item href="#"><i class="ri-delete-bin-6-fill mr-2"></i>Delete</b-dropdown-item>
                      <b-dropdown-item href="#"><i class="ri-pencil-fill mr-2"></i>Edit</b-dropdown-item>
                      <b-dropdown-item href="#"><i class="ri-printer-fill mr-2"></i>Print</b-dropdown-item>
                      <b-dropdown-item href="#"><i class="ri-file-download-fill mr-2"></i>Download</b-dropdown-item>
                    </b-dropdown>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </b-col>
  </b-row>
  </template>
<script>
import { socialvue } from '../../../config/pluginInit'

export default {
  name: 'Notification',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      seen: true,
      notificationData: [
        {
          img: require('../../../assets/images/user/01.jpg'),
          heading: 'Paige Turner Posted in UI/UX Community',
          time: '30  ago',
          icon: 'ri-award-line'
        },
        {
          img: require('../../../assets/images/user/02.jpg'),
          heading: 'Anne Fibbiyon Like Your Post',
          time: '14  ago',
          icon: 'ri-heart-line'
        },
        {
          img: require('../../../assets/images/user/03.jpg'),
          heading: 'Barry Cuda add Story',
          time: '40  ago',
          icon: 'ri-chat-4-line'
        },
        {
          img: require('../../../assets/images/user/04.jpg'),
          heading: 'Cliff Hanger posted a comment on your status update',
          time: '42  ago',
          icon: 'ri-more-fill'
        },
        {
          img: require('../../../assets/images/user/05.jpg'),
          heading: 'Rick O\'Shea posted a comment on your photo',
          time: '50  ago',
          icon: 'ri-chat-4-line'
        },
        {
          img: require('../../../assets/images/user/06.jpg'),
          heading: 'Brock Lee Sent a Friend Request',
          time: '1 hour ago',
          icon: 'ri-reply-line'
        },
        {
          img: require('../../../assets/images/user/07.jpg'),
          heading: 'Ira Membrit shared your status update',
          time: '30  ago',
          icon: 'ri-share-line'
        },
        {
          img: require('../../../assets/images/user/08.jpg'),
          heading: 'Paul Molive and 3 ther have Birthday Today',
          time: '1 day  ago',
          icon: 'las la-birthday-cake'
        },
        {
          img: require('../../../assets/images/user/09.jpg'),
          heading: 'Petey Cruiser Sent a Friend request',
          time: '1 week  ago',
          icon: 'ri-reply-line'
        },
        {
          img: require('../../../assets/images/user/10.jpg'),
          heading: 'Bob Frapples and 45 other Like Your Pst on timeline',
          time: '30  ago',
          icon: 'ri-heart-line'
        },
        {
          img: require('../../../assets/images/user/11.jpg'),
          heading: 'Maya Didas share Your Post',
          time: '1 month  ago',
          icon: 'ri-award-line'
        },
        {
          img: require('../../../assets/images/user/12.jpg'),
          heading: 'Sal Monella Add Photo with You',
          time: '30  ago',
          icon: 'ri-more-fill'
        },
        {
          img: require('../../../assets/images/user/01.jpg'),
          heading: 'Barb Dwyer commented on your new profile status',
          time: '2 month  ago',
          icon: 'ri-chat-4-line'
        },
        {
          img: require('../../../assets/images/user/13.jpg'),
          heading: 'Terry Aki commented on your new profile status',
          time: '3 month  ago',
          icon: 'ri-chat-4-line'
        }
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
      ]
    }
  }
}
</script>
