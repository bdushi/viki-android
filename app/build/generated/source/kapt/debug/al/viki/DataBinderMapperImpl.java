package al.viki;

import al.viki.databinding.DetailsPropertyPhotoItemBindingImpl;
import al.viki.databinding.DropDownItemBindingImpl;
import al.viki.databinding.DropDownItemFilterBindingImpl;
import al.viki.databinding.FragmentNewPropertyBindingImpl;
import al.viki.databinding.FragmentNewRequestBindingImpl;
import al.viki.databinding.FragmentProfileBindingImpl;
import al.viki.databinding.FragmentPropertyDetailsBindingImpl;
import al.viki.databinding.FragmentRequestDetailsBindingImpl;
import al.viki.databinding.FragmentRequestNewAccountBindingImpl;
import al.viki.databinding.LoadStateFooterViewItemBindingImpl;
import al.viki.databinding.NewPropertyHeaderItemBindingImpl;
import al.viki.databinding.NewPropertyPhotoItemBindingImpl;
import al.viki.databinding.PropertiesItemBindingImpl;
import al.viki.databinding.RequestItemBindingImpl;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_DETAILSPROPERTYPHOTOITEM = 1;

  private static final int LAYOUT_DROPDOWNITEM = 2;

  private static final int LAYOUT_DROPDOWNITEMFILTER = 3;

  private static final int LAYOUT_FRAGMENTNEWPROPERTY = 4;

  private static final int LAYOUT_FRAGMENTNEWREQUEST = 5;

  private static final int LAYOUT_FRAGMENTPROFILE = 6;

  private static final int LAYOUT_FRAGMENTPROPERTYDETAILS = 7;

  private static final int LAYOUT_FRAGMENTREQUESTDETAILS = 8;

  private static final int LAYOUT_FRAGMENTREQUESTNEWACCOUNT = 9;

  private static final int LAYOUT_LOADSTATEFOOTERVIEWITEM = 10;

  private static final int LAYOUT_NEWPROPERTYHEADERITEM = 11;

  private static final int LAYOUT_NEWPROPERTYPHOTOITEM = 12;

  private static final int LAYOUT_PROPERTIESITEM = 13;

  private static final int LAYOUT_REQUESTITEM = 14;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(14);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.details_property_photo_item, LAYOUT_DETAILSPROPERTYPHOTOITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.drop_down_item, LAYOUT_DROPDOWNITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.drop_down_item_filter, LAYOUT_DROPDOWNITEMFILTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.fragment_new_property, LAYOUT_FRAGMENTNEWPROPERTY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.fragment_new_request, LAYOUT_FRAGMENTNEWREQUEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.fragment_profile, LAYOUT_FRAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.fragment_property_details, LAYOUT_FRAGMENTPROPERTYDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.fragment_request_details, LAYOUT_FRAGMENTREQUESTDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.fragment_request_new_account, LAYOUT_FRAGMENTREQUESTNEWACCOUNT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.load_state_footer_view_item, LAYOUT_LOADSTATEFOOTERVIEWITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.new_property_header_item, LAYOUT_NEWPROPERTYHEADERITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.new_property_photo_item, LAYOUT_NEWPROPERTYPHOTOITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.properties_item, LAYOUT_PROPERTIESITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(al.viki.R.layout.request_item, LAYOUT_REQUESTITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_DETAILSPROPERTYPHOTOITEM: {
          if ("layout/details_property_photo_item_0".equals(tag)) {
            return new DetailsPropertyPhotoItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for details_property_photo_item is invalid. Received: " + tag);
        }
        case  LAYOUT_DROPDOWNITEM: {
          if ("layout/drop_down_item_0".equals(tag)) {
            return new DropDownItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for drop_down_item is invalid. Received: " + tag);
        }
        case  LAYOUT_DROPDOWNITEMFILTER: {
          if ("layout/drop_down_item_filter_0".equals(tag)) {
            return new DropDownItemFilterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for drop_down_item_filter is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNEWPROPERTY: {
          if ("layout/fragment_new_property_0".equals(tag)) {
            return new FragmentNewPropertyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_new_property is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNEWREQUEST: {
          if ("layout/fragment_new_request_0".equals(tag)) {
            return new FragmentNewRequestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_new_request is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROFILE: {
          if ("layout/fragment_profile_0".equals(tag)) {
            return new FragmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPROPERTYDETAILS: {
          if ("layout/fragment_property_details_0".equals(tag)) {
            return new FragmentPropertyDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_property_details is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREQUESTDETAILS: {
          if ("layout/fragment_request_details_0".equals(tag)) {
            return new FragmentRequestDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_request_details is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREQUESTNEWACCOUNT: {
          if ("layout/fragment_request_new_account_0".equals(tag)) {
            return new FragmentRequestNewAccountBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_request_new_account is invalid. Received: " + tag);
        }
        case  LAYOUT_LOADSTATEFOOTERVIEWITEM: {
          if ("layout/load_state_footer_view_item_0".equals(tag)) {
            return new LoadStateFooterViewItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for load_state_footer_view_item is invalid. Received: " + tag);
        }
        case  LAYOUT_NEWPROPERTYHEADERITEM: {
          if ("layout/new_property_header_item_0".equals(tag)) {
            return new NewPropertyHeaderItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for new_property_header_item is invalid. Received: " + tag);
        }
        case  LAYOUT_NEWPROPERTYPHOTOITEM: {
          if ("layout/new_property_photo_item_0".equals(tag)) {
            return new NewPropertyPhotoItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for new_property_photo_item is invalid. Received: " + tag);
        }
        case  LAYOUT_PROPERTIESITEM: {
          if ("layout/properties_item_0".equals(tag)) {
            return new PropertiesItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for properties_item is invalid. Received: " + tag);
        }
        case  LAYOUT_REQUESTITEM: {
          if ("layout/request_item_0".equals(tag)) {
            return new RequestItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for request_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(4);
    result.add(new al.bruno.adapter.DataBinderMapperImpl());
    result.add(new al.viki.authentication.DataBinderMapperImpl());
    result.add(new al.viki.foundation.DataBinderMapperImpl());
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(37);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "adapter");
      sKeys.put(2, "address");
      sKeys.put(3, "apartment");
      sKeys.put(4, "area");
      sKeys.put(5, "auth");
      sKeys.put(6, "city");
      sKeys.put(7, "cityAdapter");
      sKeys.put(8, "currency");
      sKeys.put(9, "currencyAdapter");
      sKeys.put(10, "description");
      sKeys.put(11, "floorPlanAdapter");
      sKeys.put(12, "isNotEmpty");
      sKeys.put(13, "loadState");
      sKeys.put(14, "location");
      sKeys.put(15, "newProperty");
      sKeys.put(16, "newRequestUi");
      sKeys.put(17, "onClick");
      sKeys.put(18, "operation");
      sKeys.put(19, "operationAdapter");
      sKeys.put(20, "passwordViewModel");
      sKeys.put(21, "photo");
      sKeys.put(22, "photoAdapter");
      sKeys.put(23, "price");
      sKeys.put(24, "property");
      sKeys.put(25, "propertyType");
      sKeys.put(26, "propertyTypeAdapter");
      sKeys.put(27, "propertyViewModel");
      sKeys.put(28, "registerViewModel");
      sKeys.put(29, "request");
      sKeys.put(30, "requestNewAccountViewModel");
      sKeys.put(31, "requestViewModel");
      sKeys.put(32, "selection");
      sKeys.put(33, "title");
      sKeys.put(34, "unit");
      sKeys.put(35, "unitAdapter");
      sKeys.put(36, "user");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(14);

    static {
      sKeys.put("layout/details_property_photo_item_0", al.viki.R.layout.details_property_photo_item);
      sKeys.put("layout/drop_down_item_0", al.viki.R.layout.drop_down_item);
      sKeys.put("layout/drop_down_item_filter_0", al.viki.R.layout.drop_down_item_filter);
      sKeys.put("layout/fragment_new_property_0", al.viki.R.layout.fragment_new_property);
      sKeys.put("layout/fragment_new_request_0", al.viki.R.layout.fragment_new_request);
      sKeys.put("layout/fragment_profile_0", al.viki.R.layout.fragment_profile);
      sKeys.put("layout/fragment_property_details_0", al.viki.R.layout.fragment_property_details);
      sKeys.put("layout/fragment_request_details_0", al.viki.R.layout.fragment_request_details);
      sKeys.put("layout/fragment_request_new_account_0", al.viki.R.layout.fragment_request_new_account);
      sKeys.put("layout/load_state_footer_view_item_0", al.viki.R.layout.load_state_footer_view_item);
      sKeys.put("layout/new_property_header_item_0", al.viki.R.layout.new_property_header_item);
      sKeys.put("layout/new_property_photo_item_0", al.viki.R.layout.new_property_photo_item);
      sKeys.put("layout/properties_item_0", al.viki.R.layout.properties_item);
      sKeys.put("layout/request_item_0", al.viki.R.layout.request_item);
    }
  }
}
