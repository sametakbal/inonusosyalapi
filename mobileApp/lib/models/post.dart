class Post {
  String id;
  Owner owner;
  String content;
  Null group;
  String publishedTime;
  List<Medias> medias;
  List<Comments> comments;

  Post(
      {this.id,
      this.owner,
      this.content,
      this.group,
      this.publishedTime,
      this.medias,
      this.comments});

  Post.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    owner = json['owner'] != null ? new Owner.fromJson(json['owner']) : null;
    content = json['content'];
    group = json['group'];
    publishedTime = json['publishedTime'];
    if (json['medias'] != null) {
      medias = new List<Medias>();
      json['medias'].forEach((v) {
        medias.add(new Medias.fromJson(v));
      });
    }
    if (json['comments'] != null) {
      comments = new List<Comments>();
      json['comments'].forEach((v) {
        comments.add(new Comments.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    if (this.owner != null) {
      data['owner'] = this.owner.toJson();
    }
    data['content'] = this.content;
    data['group'] = this.group;
    data['publishedTime'] = this.publishedTime;
    if (this.medias != null) {
      data['medias'] = this.medias.map((v) => v.toJson()).toList();
    }
    if (this.comments != null) {
      data['comments'] = this.comments.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class Owner {
  String id;
  String profilePicture;
  String name;
  String surname;
  String email;
  String gender;
  String status;

  Owner(
      {this.id,
      this.profilePicture,
      this.name,
      this.surname,
      this.email,
      this.gender,
      this.status});

  Owner.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    profilePicture = json['profilePicture'];
    name = json['name'];
    surname = json['surname'];
    email = json['email'];
    gender = json['gender'];
    status = json['status'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['profilePicture'] = this.profilePicture;
    data['name'] = this.name;
    data['surname'] = this.surname;
    data['email'] = this.email;
    data['gender'] = this.gender;
    data['status'] = this.status;
    return data;
  }
}

class Medias {
  String id;
  String name;
  String path;
  String type;
  int fileSize;

  Medias({this.id, this.name, this.path, this.type, this.fileSize});

  Medias.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    name = json['name'];
    path = json['path'];
    type = json['type'];
    fileSize = json['fileSize'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['name'] = this.name;
    data['path'] = this.path;
    data['type'] = this.type;
    data['fileSize'] = this.fileSize;
    return data;
  }
}

class Comments {
  String id;
  Owner owner;
  String content;
  List<Replies> replies;
  String publishedTime;

  Comments(
      {this.id, this.owner, this.content, this.replies, this.publishedTime});

  Comments.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    owner = json['owner'] != null ? new Owner.fromJson(json['owner']) : null;
    content = json['content'];
    if (json['replies'] != null) {
      replies = new List<Replies>();
      json['replies'].forEach((v) {
        replies.add(new Replies.fromJson(v));
      });
    }
    publishedTime = json['publishedTime'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    if (this.owner != null) {
      data['owner'] = this.owner.toJson();
    }
    data['content'] = this.content;
    if (this.replies != null) {
      data['replies'] = this.replies.map((v) => v.toJson()).toList();
    }
    data['publishedTime'] = this.publishedTime;
    return data;
  }
}

class Replies {
  String id;
  Owner owner;
  String content;
  String publishedTime;

  Replies({this.id, this.owner, this.content, this.publishedTime});

  Replies.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    owner = json['owner'] != null ? new Owner.fromJson(json['owner']) : null;
    content = json['content'];
    publishedTime = json['publishedTime'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    if (this.owner != null) {
      data['owner'] = this.owner.toJson();
    }
    data['content'] = this.content;
    data['publishedTime'] = this.publishedTime;
    return data;
  }
}