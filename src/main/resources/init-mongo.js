db.createUser(
    {
        user: "mongo_db_user",
        pwd: "mongo_db_pw",
        roles: [
            {
                role: "readWrite",
                db: "mongo_db"
            }
        ]
    }
)