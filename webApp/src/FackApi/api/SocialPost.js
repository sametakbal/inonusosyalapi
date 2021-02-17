import moment from 'moment'

export const Posts = [
  {
    images: [
      require('../../assets/images/page-img/p1.jpg')
    ],
    image: require('../../assets/images/page-img/p1.jpg'),
    description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
    id: '1',
    likes: 120,
    time: new Date('January 19, 2020 11:30:25'),
    is_follow: true,
    is_liked: true,
    user: { profile: require('../../assets/images/page-img/g1.jpg'), name: 'Nik Jon' },
    comments: [
      { image: require('../../assets/images/user/user-04.jpg'), user: { name: 'Paul Molive', msg: 'Lorem ipsum dolor sit amet', time: moment(new Date(), 'YYYY-MM-DD H:i:s').add(-3, 'days') }, is_commentLike: true },
      { image: require('../../assets/images/user/user-03.jpg'), user: { name: 'Paul Molive', msg: 'Lorem ipsum dolor sit amet', time: moment(new Date(), 'YYYY-MM-DD H:i:s').add(-2, 'days') }, is_commentLike: true }
    ]
  },
  {
    images: [
      require('../../assets/images/page-img/p1.jpg'),
      require('../../assets/images/page-img/p1.jpg'),
      require('../../assets/images/page-img/p1.jpg')
    ],
    image: require('../../assets/images/page-img/p1.jpg'),
    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ',
    id: '2',
    likes: 140,
    time: new Date('December 31, 2019 11:30:25'),
    is_follow: true,
    is_liked: false,
    is_commentLike: true,
    user: { profile: require('../../assets/images/page-img/g2.jpg'), name: 'John' },
    comments: [
      { image: require('../../assets/images/user/user-01.jpg'), user: { name: 'Paul Molive', msg: 'Lorem ipsum dolor sit amet', time: moment(new Date(), 'YYYY-MM-DD H:i:s').add(-4, 'days') }, is_commentLike: true },
      { image: require('../../assets/images/user/user-02.jpg'), user: { name: 'Paul Molive', msg: 'Lorem ipsum dolor sit amet', time: moment(new Date(), 'YYYY-MM-DD H:i:s').add(-1, 'days') }, is_commentLike: true }
    ]
  },
  {
    images: [
      require('../../assets/images/page-img/p1.jpg'),
      require('../../assets/images/page-img/p1.jpg'),
      require('../../assets/images/page-img/p1.jpg')
    ],
    image: require('../../assets/images/page-img/p1.jpg'),
    description: null,
    id: '3',
    likes: 140,
    time: new Date('December 31, 2017 11:30:25'),
    is_follow: false,
    is_liked: false,
    is_commentLike: true,
    user: { profile: require('../../assets/images/page-img/g3.jpg'), name: 'Jack' },
    comments: [
      { image: require('../../assets/images/user/user-01.jpg'), user: { name: 'Paul Molive', msg: 'Lorem ipsum dolor sit amet', time: moment(new Date(), 'YYYY-MM-DD H:i:s').add(-60, 'minutes') }, is_commentLike: true },
      { image: require('../../assets/images/user/user-02.jpg'), user: { name: 'Paul Molive', msg: 'Lorem ipsum dolor sit amet', time: moment(new Date(), 'YYYY-MM-DD H:i:s').add(-15, 'minutes') }, is_commentLike: true }
    ]
  },
  {
    images: [
      require('../../assets/images/page-img/p1.jpg'),
      require('../../assets/images/page-img/p1.jpg'),
      require('../../assets/images/page-img/p1.jpg')
    ],
    image: null,
    description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ',
    id: '4',
    likes: 90,
    time: new Date('December 31, 2019 11:30:25'),
    is_follow: false,
    is_liked: false,
    is_commentLike: true,
    user: { profile: require('../../assets/images/page-img/g3.jpg'), name: 'Jack' },
    comments: [
      { image: require('../../assets/images/user/user-04.jpg'), user: { name: 'Paul Molive', msg: 'Lorem ipsum dolor sit amet', time: moment(new Date(), 'YYYY-MM-DD H:i:s').add(-60, 'minutes') }, is_commentLike: true },
      { image: require('../../assets/images/user/user-03.jpg'), user: { name: 'Paul Molive', msg: 'Lorem ipsum dolor sit amet', time: moment(new Date(), 'YYYY-MM-DD H:i:s').add(-15, 'minutes') }, is_commentLike: true }
    ]
  }
]
