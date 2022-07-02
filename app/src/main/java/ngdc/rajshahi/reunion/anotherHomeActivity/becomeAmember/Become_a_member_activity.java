package ngdc.rajshahi.reunion.anotherHomeActivity.becomeAmember;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ngdc.rajshahi.reunion.R;

public class Become_a_member_activity extends AppCompatActivity {
    EditText formName,
            formMobile,
            formPresentAddress,
            formPermanentAddress,
            formImageFileChooserFileName,
            formEmail,
            formPassword,
            formPasswordConfirm,
            formGroup,
            formNameSpouse,
            formNumberOfChild,
            formOccupation,
            formInstituteName,
            formDesignation,
            formOfficeAddress;

    Button formSubmitButton,
            formImageFileChooserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_become_amember);
        this.setTitle("Become a Member");
        utilizedUI();

        formImageFileChooserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String imageLink ="";
                formImageFileChooserFileName.setText(imageLink);
            }
        });

        String formName_Collected = formName.getText().toString().trim();
        String formMobile_Collected = formMobile.getText().toString().trim();
        String formPresentAddress_Collected = formPresentAddress.getText().toString().trim();
        String formPermanentAddress_Collected = formPermanentAddress.getText().toString().trim();
        String formImageFileChooserFileName_Collected = formImageFileChooserFileName.getText().toString().trim();

        String formEmail_Collected = formEmail.getText().toString().trim();
        String formPassword_Collected = formPassword.getText().toString().trim();
        String formPasswordConfirm_Collected = formPasswordConfirm.getText().toString().trim();

        String formGroup_Collected = formGroup.getText().toString().trim();

        String formNameSpouse_Collected = formNameSpouse.getText().toString().trim();
        String formNumberOfChild_Collected = formNumberOfChild.getText().toString().trim();

        String formOccupation_Collected = formOccupation.getText().toString().trim();
        String formInstituteName_Collected = formInstituteName.getText().toString().trim();
        String formDesignation_Collected = formDesignation.getText().toString().trim();
        String formOfficeAddress_Collected = formOfficeAddress.getText().toString().trim();


        formSubmitButton.setOnClickListener(view -> {
            if (formName_Collected.equals("") ||
                    formMobile_Collected.equals("") ||
                    formPresentAddress_Collected.equals("") ||
                    formPermanentAddress_Collected.equals("") ||
                    formGroup_Collected.equals("") ||
                    formOccupation_Collected.equals("") ||
                    formInstituteName_Collected.equals("") ||
                    formDesignation_Collected.equals("") ||
                    formPassword_Collected.equals("") ||
                    formPasswordConfirm_Collected.equals("")) {
                Toast.makeText(this, "Fill up required information", Toast.LENGTH_SHORT).show();
            } else {
                if (!formPassword_Collected.equals(formPasswordConfirm_Collected)){
                    Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Successful submit your data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void utilizedUI() {
        formSubmitButton = findViewById(R.id.formSubmitButton);

        formName = findViewById(R.id.formName);
        formMobile = findViewById(R.id.formMobile);
        formPresentAddress = findViewById(R.id.formPresentAddress);
        formPermanentAddress = findViewById(R.id.formPermanentAddress);
        formImageFileChooserButton = findViewById(R.id.formImageFileChooserButton);
        formEmail = findViewById(R.id.formEmail);
        formPassword = findViewById(R.id.formPassword);
        formPasswordConfirm = findViewById(R.id.formPasswordConfirm);

        formGroup = findViewById(R.id.formGroup);

        formNameSpouse = findViewById(R.id.formNameSpouse);
        formNumberOfChild = findViewById(R.id.formNumberOfChild);

        formOccupation = findViewById(R.id.formOccupation);
        formInstituteName = findViewById(R.id.formInstituteName);
        formDesignation = findViewById(R.id.formDesignation);
        formOfficeAddress = findViewById(R.id.formOfficeAddress);
    }
}