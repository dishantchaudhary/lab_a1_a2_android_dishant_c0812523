// Generated by view binder compiler. Do not edit!
package com.example.lab_a1_a2_android_dishant_c0812523.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lab_a1_a2_android_dishant_c0812523.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProviderfragmentLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView rvProvider;

  private ProviderfragmentLayoutBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView rvProvider) {
    this.rootView = rootView;
    this.rvProvider = rvProvider;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProviderfragmentLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProviderfragmentLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.providerfragment_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProviderfragmentLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rvProvider;
      RecyclerView rvProvider = ViewBindings.findChildViewById(rootView, id);
      if (rvProvider == null) {
        break missingId;
      }

      return new ProviderfragmentLayoutBinding((ConstraintLayout) rootView, rvProvider);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
