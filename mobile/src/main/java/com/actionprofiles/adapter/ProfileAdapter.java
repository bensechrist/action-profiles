package com.actionprofiles.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionprofiles.R;
import com.actionprofiles.model.Profile;

import java.util.List;

/**
 * @author Ben Sechrist
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

  private List<Profile> profiles;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public View view;

    public ViewHolder(View v) {
      super(v);
      this.view = v;
    }
  }

  public ProfileAdapter(List<Profile> profiles) {
    this.profiles = profiles;
  }

  // Create new views (invoked by the layout manager)
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // create a new view
    LayoutInflater from = LayoutInflater.from(parent.getContext());
    assert from != null;
    View v = from.inflate(R.layout.profile_item_view, parent, false);
    return new ViewHolder(v);
  }

  // Replace the contents of a view (invoked by the layout manager)
  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    TextView textView = (TextView) holder.view.findViewById(R.id.profile_name);
    textView.setText(profiles.get(position).name);
  }

  // Return the size of your dataset (invoked by the layout manager)
  @Override
  public int getItemCount() {
    return profiles.size();
  }

}
