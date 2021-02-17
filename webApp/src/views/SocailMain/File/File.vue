<template>
 <b-row>
   <b-col sm="12">
     <iq-card>
       <template v-slot:headerTitle>
         <h4 class="card-title">Files</h4>
       </template>
       <template v-slot:headerAction>
         <b-dropdown id="dropdownMenuButton40" right variant="link p-0" menu-class="p-0">
           <template v-slot:button-content>
             <b-link href="#" class="dropdown-toggle text-primary"><i class="ml-3 ri-more-2-line"></i></b-link>
           </template>
           <b-dropdown-item href="#"><i class="ri-eye-fill mr-2"></i>View</b-dropdown-item>
           <b-dropdown-item href="#"><i class="ri-delete-bin-6-fill mr-2"></i>Delete</b-dropdown-item>
           <b-dropdown-item href="#"><i class="ri-pencil-fill mr-2"></i>Edit</b-dropdown-item>
           <b-dropdown-item href="#"><i class="ri-printer-fill mr-2"></i>Print</b-dropdown-item>
           <b-dropdown-item href="#"><i class="ri-file-download-fill mr-2"></i>Download</b-dropdown-item>
         </b-dropdown>
       </template>
       <b-card-body class="iq-card-body">
         <div class="table-responsive">
           <div class="row justify-content-between">
             <div class="col-sm-12 col-md-6">
               <div id="user_list_datatable_info" class="dataTables_filter">
                 <form class="mr-3 position-relative">
                   <div class="form-group mb-0">
                     <input type="search" class="form-control" id="exampleInputSearch" placeholder="Search">
                   </div>
                 </form>
               </div>
             </div>
             <div class="col-sm-12 col-md-6">
               <div class="user-list-files d-flex float-right">
                 <a href="#" class="chat-icon-phone btn iq-bg-primary">
                   Print
                 </a>
                 <a href="#" class="chat-icon-video btn iq-bg-primary">
                   Excel
                 </a>
                 <a href="#" class="chat-icon-delete btn iq-bg-primary">
                   Pdf
                 </a>
               </div>
             </div>
           </div>
           <table class="files-lists table table-striped mt-4">
             <thead>
             <tr>
               <th scope="col">
                 <div class="checkbox text-center">
                   <input type="checkbox" class="checkbox-input">
                 </div>
               </th>
               <th scope="col">File Name</th>
               <th scope="col">File Type</th>
               <th scope="col">Date</th>
               <th scope="col">Size</th>
               <th scope="col">Author</th>
               <th scope="col">Action</th>
             </tr>
             </thead>
             <tbody>
             <tr v-for="(item,index) in fileData" :key="index">
               <td>
                 <div class="checkbox text-center">
                   <input type="checkbox" class="checkbox-input">
                 </div>
               </td>
               <td>
                 <img class="rounded-circle img-fluid avatar-40 mr-2" :src="item.img" alt="profile"> {{item.imgTitle}}
               </td>
               <td>{{item.heading}}</td>
               <td>
                 {{item.date}}
               </td>
               <td>{{item.size}}</td>
               <td>
                 {{item.user}}
               </td>
               <td>
                 <div class="flex align-items-center list-user-action">
                   <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Download" href="#"><i class="ri-download-line"></i></a>
                   <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Delete" href="#"><i class="ri-delete-bin-line"></i></a>
                 </div>
               </td>
             </tr>
             </tbody>
           </table>
         </div>

       </b-card-body>
     </iq-card>

   </b-col>
 </b-row>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
export default {
  name: 'File',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      fileData: [
        {
          img: require('../../../assets/images/page-img/43.png'),
          imgTitle: 'post report',
          heading: 'Document',
          date: 'Mar 12, 2020',
          size: '390 kb',
          user: 'Anna Sthesia'
        },
        {
          img: require('../../../assets/images/page-img/44.png'),
          imgTitle: 'usages',
          heading: 'Document',
          date: ' Mar 18, 2020 ',
          size: '390 kb',
          user: ' Paul Molive '
        },
        {
          img: require('../../../assets/images/page-img/45.png'),
          imgTitle: 'Images file',
          heading: 'Document',
          date: 'Mar 19, 2020',
          size: '600 kb',
          user: ' Bob Frapples '
        },
        {
          img: require('../../../assets/images/page-img/46.png'),
          imgTitle: 'total comments ',
          heading: 'Slide',
          date: 'Mar 21, 2020',
          size: '800 kb',
          user: ' Barb Ackue '
        },
        {
          img: require('../../../assets/images/page-img/47.png'),
          imgTitle: 'popular events',
          heading: 'excel',
          date: 'Mar 24, 2020',
          size: '500 kb',
          user: 'Anna Sthesia'
        },
        {
          img: require('../../../assets/images/page-img/43.png'),
          imgTitle: 'todo list',
          heading: 'Pdf',
          date: 'Mar 28, 2020',
          size: '320 kb',
          user: ' Ira Membrit '
        },
        {
          img: require('../../../assets/images/page-img/44.png'),
          imgTitle: 'music list',
          heading: 'Pdf',
          date: 'Mar 30, 2020',
          size: '600 kb',
          user: 'Anna Sthesia'
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
