class UserModel {
  final String? id;
  final String email;
  final DateTime? timestamp;

  UserModel({
    this.id,
    required this.email,
    this.timestamp,
  });

  // Convert UserModel to a Map for Firestore
  Map<String, dynamic> toMap() {
    return {
      'email': email,
      'timestamp': timestamp ?? DateTime.now(),
    };
  }

  // Create UserModel from a Firestore document
  factory UserModel.fromMap(Map<String, dynamic> data, String id) {
    return UserModel(
      id: id,
      email: data['email'],
      timestamp: data['timestamp']?.toDate(),
    );
  }
}
