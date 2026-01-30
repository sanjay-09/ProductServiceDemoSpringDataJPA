CREATE TABLE `driver` (
   `id` bigint NOT NULL,
   `created_at` datetime(6) DEFAULT NULL,
   `updated_at` datetime(6) DEFAULT NULL,
   `license_number` varchar(255) NOT NULL,
   `name` varchar(255) NOT NULL,
   PRIMARY KEY (`id`)
 )ENGINE=InnoDB;