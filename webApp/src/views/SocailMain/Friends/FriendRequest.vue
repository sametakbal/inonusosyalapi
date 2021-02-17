<template>
 <b-row>
     <b-col sm="12">
         <iq-card v-for="(item,index) in friendRequest" :key="index">
             <template v-slot:headerTitle>
               <h4 class="card-title">{{item.title}}</h4>
             </template>
             <template v-slot:body>
                 <ul class="request-list list-inline m-0 p-0">
                     <li class="d-flex align-items-center" v-for="(list,index1) in item.list" :key="index1">
                         <div class="user-img img-fluid"><img :src="list.img" alt="story-img" class="rounded-circle avatar-40"></div>
                         <div class="media-support-info ml-3">
                             <h6>{{list.name}}</h6>
                             <p class="mb-0">{{list.friend}}</p>
                         </div>
                         <div class="d-flex align-items-center">
                             <a href="#" class="mr-3 btn btn-primary rounded"><i v-if="(item.title == 'People You May Know')" class="ri-user-add-line"></i>{{item.btn1}}</a>
                             <a href="#" class="mr-3 btn btn-secondary rounded">{{item.btn2}}</a>
                         </div>
                     </li>
                     <li v-if = "(item.title == 'Friend Request')" class="d-block text-center">
                         <a href="#" class="mr-3 btn">View More Request</a>
                     </li>
                 </ul>
             </template>
         </iq-card>

     </b-col>
 </b-row>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
export default {
  name: 'FriendRequest',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      friendRequest: [
        {
          title: 'Friend Request',
          btn1: 'Confirm',
          btn2: 'Delete Request',
          list: [
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
            },
            {
              img: require('../../../assets/images/user/09.jpg'),
              name: 'Marsha Mello',
              friend: '15  friends'
            },
            {
              img: require('../../../assets/images/user/10.jpg'),
              name: 'Caire Innet',
              friend: '8  friends'
            },
            {
              img: require('../../../assets/images/user/11.jpg'),
              name: 'Gio Metric',
              friend: '10  friends'
            },
            {
              img: require('../../../assets/images/user/12.jpg'),
              name: 'Chris P. Cream',
              friend: '18  friends'
            },
            {
              img: require('../../../assets/images/user/05.jpg'),
              name: 'Paul Misunday',
              friend: '6  friends'
            },
            {
              img: require('../../../assets/images/user/13.jpg'),
              name: 'Reanne Carnation',
              friend: '12  friends'
            }
          ]

        },
        {
          title: 'People You May Know',
          btn1: 'Add Friend',
          btn2: 'Remove',
          list: [
            {
              img: require('../../../assets/images/user/14.jpg'),
              name: 'Jen Youfelct',
              friend: '4 friends'
            },
            {
              img: require('../../../assets/images/user/15.jpg'),
              name: 'Jen Youfelct',
              friend: '20  friends'
            },
            {
              img: require('../../../assets/images/user/16.jpg'),
              name: 'Jaques Amole',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/17.jpg'),
              name: 'Earl E. Riser',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/18.jpg'),
              name: 'Cliff Diver',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/19.jpg'),
              name: 'Cliff Diver',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/05.jpg'),
              name: 'Joyce Tick',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/18.jpg'),
              name: 'Vinny Gret',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/06.jpg'),
              name: 'Paul Samic',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/07.jpg'),
              name: 'Gustav Wind',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/05.jpg'),
              name: 'Minnie Strone',
              friend: '40  friends'
            },
            {
              img: require('../../../assets/images/user/04.jpg'),
              name: 'Ray Volver',
              friend: '40  friends'
            }
          ]
        }
      ]
    }
  }
}
</script>
