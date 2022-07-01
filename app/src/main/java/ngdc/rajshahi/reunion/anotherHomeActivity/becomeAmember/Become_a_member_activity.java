package ngdc.rajshahi.reunion.anotherHomeActivity.becomeAmember;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ngdc.rajshahi.reunion.R;

public class Become_a_member_activity extends AppCompatActivity {
    EditText formPasswordConfirm,
            formPassword,
            formName,
            formEmail,
            formMobile,
            formPresentAddress,
            formPermanentAddress,
            formGroup,
            formNameFather,
            formNameMother,
            formNameSpouse,
            formNumberOfChild,
            formOccupation,
            formInstituteName,
            formDesignation,
            formOfficeAddress,
            formMemberType;
    Button formSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_become_amember);
        this.setTitle("Become a Member");
        utilizedUI();

        String formNameCollected = formName.getText().toString().trim();
        String formEmailCollected = formEmail.getText().toString().trim();
        String formMobileCollected = formMobile.getText().toString().trim();
        String formPresentAddressCollected = formPresentAddress.getText().toString().trim();
        String formPermanentAddressCollected = formPermanentAddress.getText().toString().trim();
        String formGroupCollected = formGroup.getText().toString().trim();
        String formNameFatherCollected = formNameFather.getText().toString().trim();
        String formNameMotherCollected = formNameMother.getText().toString().trim();
        String formNameSpouseCollected = formNameSpouse.getText().toString().trim();
        String formNumberOfChildCollected = formNumberOfChild.getText().toString().trim();
        String formOccupationCollected = formOccupation.getText().toString().trim();
        String formInstituteNameCollected = formInstituteName.getText().toString().trim();
        String formDesignationCollected = formDesignation.getText().toString().trim();
        String formOfficeAddressCollected = formOfficeAddress.getText().toString().trim();
        String formMemberTypeCollected = formMemberType.getText().toString().trim();
        String formPasswordCollected = formPassword.getText().toString().trim();
        String formPasswordConfirmCollected = formPasswordConfirm.getText().toString().trim();

        formSubmitButton.setOnClickListener(view -> {
            if (formNameCollected.equals("") ||
                    formEmailCollected.equals("") ||
                    formMobileCollected.equals("") ||
                    formPresentAddressCollected.equals("") ||
                    formPermanentAddressCollected.equals("") ||
                    formGroupCollected.equals("") ||
                    formNameFatherCollected.equals("") ||
                    formNameMotherCollected.equals("") ||
                    formNameSpouseCollected.equals("") ||
                    formNumberOfChildCollected.equals("") ||
                    formOccupationCollected.equals("") ||
                    formInstituteNameCollected.equals("") ||
                    formDesignationCollected.equals("") ||
                    formOfficeAddressCollected.equals("") ||
                    formPasswordCollected.equals("") ||
                    formPasswordConfirmCollected.equals("") ||
                    formMemberTypeCollected.equals("")) {
                if (!formPasswordCollected.equals(formPasswordConfirmCollected)) {
                    Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Fill up all information", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Successful submit your data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void utilizedUI() {
        formSubmitButton = findViewById(R.id.formSubmitButton);
        formName = findViewById(R.id.formName);
        formEmail = findViewById(R.id.formEmail);
        formMobile = findViewById(R.id.formMobile);
        formPresentAddress = findViewById(R.id.formPresentAddress);
        formPermanentAddress = findViewById(R.id.formPermanentAddress);
        formGroup = findViewById(R.id.formGroup);
        formNameFather = findViewById(R.id.formNameFather);
        formNameMother = findViewById(R.id.formNameMother);
        formNameSpouse = findViewById(R.id.formNameSpouse);
        formNumberOfChild = findViewById(R.id.formNumberOfChild);
        formOccupation = findViewById(R.id.formOccupation);
        formInstituteName = findViewById(R.id.formInstituteName);
        formDesignation = findViewById(R.id.formDesignation);
        formOfficeAddress = findViewById(R.id.formOfficeAddress);
        formMemberType = findViewById(R.id.formMemberType);
        formPassword = findViewById(R.id.formPassword);
        formPasswordConfirm = findViewById(R.id.formPasswordConfirm);
    }
}