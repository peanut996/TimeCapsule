package models

type Capsule struct {
	ID          int    `json:"id" gorm:"primary_key;not null;auto_increment"`
	Content     string `json:"content" gorm:"size:4096"`
	CreatedAt   string `json:"createtime" gorm:"default:current_time;column:createtime"`
	Opentime    string `json:"opentime" gorm:"default:current_time"`
	Uuid        string `json:"uuid" gorm:"not null;unique" binding:"required"`
	Username    string `json:"username" gorm:"not null"`
	Warncontent string `json:"warncontent" gorm:"default:null"`
	Email       string `json:"email" gorm:"not null"`
}

func (Capsule) TableName() string {
	return "capsule"
}

func GetAllCapsule() ([]*Capsule, error) {
	capsules := make([]*Capsule, 0)
	err := db.Find(&capsules).Error
	if err != nil {
		return nil, err
	}
	return capsules, nil
}
func GetCapsuleByUuid(uuid string) (*Capsule, error) {
	capsule := &Capsule{}
	if err := db.Find(capsule).Error; err != nil {
		return nil, err
	}
	return capsule, nil
}
func AddCapsule(capsule *Capsule) error {
	if err := db.Create(capsule).Error; err != nil {
		return err
	}
	return nil
}
func DeleteCapsuleByUuid(uuid string) error {
	if err := db.Where("uuid = ?", uuid).Delete(Capsule{}).Error; err != nil {
		return err
	}
	return nil
}

//fixme
func UpdateCapsule(capsule *Capsule) error {
	oldcapsule, err := GetCapsuleByUuid(capsule.Uuid)
	if err != nil {
		return err
	}
	capsule.ID = oldcapsule.ID
	if err := db.Save(capsule).Error; err != nil {
		return err
	}
	return nil
}
