import 'package:flutter/material.dart';
import 'package:mobileApp/pages/feed_page.dart';
import 'package:mobileApp/pages/messages_page.dart';
import 'package:mobileApp/pages/post_page.dart';
import 'package:mobileApp/pages/profile_page.dart';
import 'package:mobileApp/pages/search_page.dart';
import 'package:mobileApp/util/util.dart';

class AppPage extends StatefulWidget {
  @override
  _AppPageState createState() => _AppPageState();
}

class _AppPageState extends State<AppPage> {
  int _selectedIndex = 0;
  List<Widget> _pages = [
    FeedPage(),
    MessagesPage(),
    PostPage(),
    SearchPage(),
    ProfilePage()
  ];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sosyal'),
        centerTitle: true,
      ),
      body: _pages.elementAt(_selectedIndex),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        iconSize: 25.0,
        elevation: 0.0,
        showSelectedLabels: false,
        showUnselectedLabels: false,
        items: [
          BottomNavigationBarItem(
              icon: Icon(
                Icons.home_outlined,
                color: iconColor,
              ),
              label: 'Home'),
          BottomNavigationBarItem(
              icon: Icon(
                Icons.message_outlined,
                color: iconColor,
              ),
              label: 'Messages'),
          BottomNavigationBarItem(
              icon: Icon(
                Icons.add_box_outlined,
                color: iconColor,
              ),
              label: 'New'),
          BottomNavigationBarItem(
              icon: Icon(
                Icons.search,
                color: iconColor,
              ),
              label: 'Search'),
          BottomNavigationBarItem(
              icon: Icon(
                Icons.person_outline_outlined,
                color: iconColor,
              ),
              label: 'Profile'),
        ],
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
      ),
    );
  }

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }
}
