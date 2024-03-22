//package com.example.projectnhatro;
//
//import android.content.Context;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//
//public class calculatedBill extends bill{
//    Context mContext;
//    EditText oldElectric, newElectric;
//
//    Spinner cashRent;
//
//    public calculatedBill(Context context) {
//        mContext = context;
//    }
//
//    public void totalPrice() {
//
//
//        cashRent = findViewById(R.id.spinerBill_cashRent);
//        String[] cashPrice = {"4000000", "5000000"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cashPrice);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        cashRent.setAdapter(adapter);
//
//
//        oldElectric = ((bill)mContext).findViewById(R.id.edtBill_oldElectric);
//        newElectric = ((bill)mContext).findViewById(R.id.edtBill_newElectric);
//        String old_Electric = oldElectric.getText().toString();
//        String new_Electric = newElectric.getText().toString();
//        String cash_Rent = cashRent.getSelectedItem().toString();
//
//
//        // Kiểm tra xem chuỗi có rỗng không trước khi chuyển đổi
//        if (!old_Electric.isEmpty() && !new_Electric.isEmpty() && !cash_Rent.isEmpty()) {
//            int intOld_Electric = Integer.parseInt(old_Electric);
//            int intNew_Electric = Integer.parseInt(new_Electric);
//            int intCash_Rent = Integer.parseInt(cash_Rent);
//
//            int useElectric = intNew_Electric - intOld_Electric;
//            int priceElectric = useElectric * 3500;
//
//            totalRent = priceElectric + intCash_Rent + water ;
//
//            // Hiển thị kết quả tính toán
////            kq.setText(String.valueOf(totalRent));
//        }
//    }
//
//
//
//
//
//
//}
