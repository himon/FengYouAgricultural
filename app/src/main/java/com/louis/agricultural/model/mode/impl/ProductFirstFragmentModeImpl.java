package com.louis.agricultural.model.mode.impl;

import android.support.v4.app.Fragment;
import com.louis.agricultural.base.mode.BaseMode;
import com.louis.agricultural.callback.UserLoseMultiLoadedListener;
import com.louis.agricultural.model.mode.ProductFirstFragmentMode;
import com.louis.agricultural.utils.manager.HttpManager;

public class ProductFirstFragmentModeImpl extends BaseMode
  implements ProductFirstFragmentMode
{
  private Fragment mFragment;

  public ProductFirstFragmentModeImpl(Fragment paramFragment)
  {
    this.mFragment = paramFragment;
  }

  public void getAddGoodscart(String paramString1, String paramString2, String paramString3, UserLoseMultiLoadedListener paramUserLoseMultiLoadedListener)
  {
    this.mManager.getAddGoodscart(paramString1, paramString2, paramString3, paramUserLoseMultiLoadedListener, null, this.mFragment);
  }
}