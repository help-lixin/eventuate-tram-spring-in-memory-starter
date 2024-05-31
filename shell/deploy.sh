# 一键配置pom中版本
# mvn versions:set -DnewVersion=1.0.6

# 发布到远程仓库
mvn  deploy -P release -DskipTests

# 一键配置pom中版本
# mvn versions:set -DnewVersion=1.0.1-SNAPHOST