3. Clone repository về máy (cho mỗi thành viên)
Mỗi thành viên chạy lệnh:

git clone https://github.com/muabang123/Quan-ly-cua-hang-dien-thoai.git
cd Quan-ly-cua-hang-dien-thoai

4. Tạo branch riêng cho từng thành viên
Mỗi người tạo branch mới (đặt tên theo chức năng hoặc tên cá nhân):
git checkout -b ten_branch
git push -u origin ten_branch
Ví dụ:
git checkout -b feature-login
git push -u origin feature-login


5. Mỗi thành viên làm việc trên branch của mình
Viết code, commit:
git add .
git commit -m "Thêm chức năng login"
git push origin ten_branch


6. Cập nhật code từ người khác (pull branch khác về)
Lấy danh sách branch trên remote:
git fetch --all
Chuyển sang branch cần lấy code:
git checkout feature-login  # Hoặc branch khác
git pull origin feature-login
Nếu muốn cập nhật branch chính (main):
git checkout main
git pull origin main


7. Gộp branch vào main (Pull Request - PR)
Sau khi hoàn thành tính năng, mỗi thành viên:

Vào GitHub, mở repo → "Pull Requests" → "New Pull Request".
Chọn branch nguồn (branch của mình) → Chọn đích (main).
Nhấn "Create Pull Request".
Trưởng nhóm review, nếu OK thì merge vào main.


8. Cập nhật code mới sau khi merge
Sau khi branch khác đã merge vào main, các thành viên nên cập nhật:
git checkout main
git pull origin main
git checkout ten_branch
git merge main


9. Xoá branch khi hoàn thành (tùy chọn)
Nếu branch không còn cần nữa:
git branch -d ten_branch  # Xóa local
git push origin --delete ten_branch  # Xóa trên remote