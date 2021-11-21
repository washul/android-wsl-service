package com.wsl.login.databinding;
import com.wsl.login.R;
import com.wsl.login.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentRegisterBindingImpl extends FragmentRegisterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.progress_bar_, 9);
        sViewsWithIds.put(R.id.image_profile_, 10);
        sViewsWithIds.put(R.id.holder_name, 11);
        sViewsWithIds.put(R.id.last_name, 12);
        sViewsWithIds.put(R.id.email_, 13);
        sViewsWithIds.put(R.id.passwordLayout1, 14);
        sViewsWithIds.put(R.id.editTextPasswrdod1, 15);
        sViewsWithIds.put(R.id.passwordLayout2, 16);
        sViewsWithIds.put(R.id.editTextPasswrdod2, 17);
        sViewsWithIds.put(R.id.linearLayout, 18);
        sViewsWithIds.put(R.id.textView3, 19);
        sViewsWithIds.put(R.id.radioGroup2, 20);
        sViewsWithIds.put(R.id.first, 21);
        sViewsWithIds.put(R.id.second, 22);
        sViewsWithIds.put(R.id.country_, 23);
        sViewsWithIds.put(R.id.state_, 24);
        sViewsWithIds.put(R.id.city_, 25);
        sViewsWithIds.put(R.id.address_, 26);
        sViewsWithIds.put(R.id.phone_, 27);
        sViewsWithIds.put(R.id.linearLayout3, 28);
        sViewsWithIds.put(R.id.chip_group, 29);
        sViewsWithIds.put(R.id.registrarse_, 30);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRegisterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 31, sIncludes, sViewsWithIds));
    }
    private FragmentRegisterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.textfield.TextInputLayout) bindings[26]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.chip.ChipGroup) bindings[29]
            , (com.google.android.material.textfield.TextInputLayout) bindings[25]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[23]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (com.google.android.material.textfield.TextInputEditText) bindings[15]
            , (com.google.android.material.textfield.TextInputEditText) bindings[17]
            , (com.google.android.material.textfield.TextInputLayout) bindings[13]
            , (android.widget.RadioButton) bindings[21]
            , (com.google.android.material.textfield.TextInputLayout) bindings[11]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (android.widget.ImageView) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[12]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.LinearLayout) bindings[28]
            , (com.google.android.material.textfield.TextInputLayout) bindings[14]
            , (com.google.android.material.textfield.TextInputLayout) bindings[16]
            , (com.google.android.material.textfield.TextInputLayout) bindings[27]
            , (com.google.android.material.textfield.TextInputEditText) bindings[8]
            , (android.widget.ProgressBar) bindings[9]
            , (android.widget.RadioGroup) bindings[20]
            , (com.google.android.material.button.MaterialButton) bindings[30]
            , (android.widget.RadioButton) bindings[22]
            , (com.google.android.material.textfield.TextInputLayout) bindings[24]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (android.widget.TextView) bindings[19]
            );
        this.addressText.setTag(null);
        this.cityText.setTag(null);
        this.countryText.setTag(null);
        this.editTextEmail.setTag(null);
        this.holderNameText.setTag(null);
        this.lastNameText.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.phoneText.setTag(null);
        this.stateText.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.vm == variableId) {
            setVm((com.wsl.login.login.view_model.WSLoginViewModel) variable);
        }
        else if (BR.user == variableId) {
            setUser((com.wsl.login.database.entities.EUser) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable com.wsl.login.login.view_model.WSLoginViewModel Vm) {
        this.mVm = Vm;
    }
    public void setUser(@Nullable com.wsl.login.database.entities.EUser User) {
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String userCountry = null;
        java.lang.String userCity = null;
        java.lang.String userName = null;
        java.lang.String userEmail = null;
        java.lang.String userLastName = null;
        java.lang.String userState = null;
        java.lang.String userAddress = null;
        com.wsl.login.database.entities.EUser user = mUser;
        java.lang.String userPhone = null;

        if ((dirtyFlags & 0x6L) != 0) {



                if (user != null) {
                    // read user.country
                    userCountry = user.getCountry();
                    // read user.city
                    userCity = user.getCity();
                    // read user.name
                    userName = user.getName();
                    // read user.email
                    userEmail = user.getEmail();
                    // read user.last_name
                    userLastName = user.getLast_name();
                    // read user.state
                    userState = user.getState();
                    // read user.address
                    userAddress = user.getAddress();
                    // read user.phone
                    userPhone = user.getPhone();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.addressText, userAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cityText, userCity);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.countryText, userCountry);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.editTextEmail, userEmail);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.holderNameText, userName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.lastNameText, userLastName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.phoneText, userPhone);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.stateText, userState);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): user
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}