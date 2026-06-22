# ใช้ Payara Micro เป็น base image
FROM payara/micro:6.2025.11-jdk21

# คัดลอกไฟล์ .war ของแอปเข้าไปใน container
COPY target/ws-server-microprofile.war \
     $DEPLOY_DIR/ws-server-microprofile.war
	 
# เปิด port ที่ต้องใช้
EXPOSE 8080 


#docker build -f Dockerfile -t payara6-micro .
#docker run -p 8080:8080 --name payara6 payara6-micro
#docker run -d -p 8080:8080 --name payara6 payara6-micro